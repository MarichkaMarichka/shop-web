<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="store.ItemsRepository" %>
<%@ page import="models.Item" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
    <link rel="stylesheet" type="text/css" href="styles.css" />

</head>
<body>

<!-- Start Container -->
    <div class="container">

        <!-- Start Header -->
                <div class="bs-example">
                    <nav role="navigation" class="navbar navbar-default">
                        <!-- Brand and toggle get grouped for better mobile display -->
                        <div class="navbar-header">
                            <button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                            <a href="SelectServlet" class="navbar-brand">SombraShop</a>
                        </div>
                        <!-- Collection of nav links, forms, and other content for toggling -->
                        <div id="navbarCollapse" class="collapse navbar-collapse">
                            <form role="search" class="navbar-form navbar-left">
                                <div class="form-group">
                                    <input type="text" placeholder="Search" class="form-control">
                                </div>
                            </form>
                            <%if(session.getAttribute("id_user")!=null){%>
                            <ul class="nav navbar-nav navbar-right">
                                <li><a href="LogoutServlet" >Log Out</a></li>
                            </ul>
                                <%if(session.getAttribute("login").equals("admin")){%>
                                     <ul class="nav navbar-nav navbar-right">
                                         <li><a href="AdminSelectServlet" >Admin Profile</a></li>
                                     </ul>
                                <%}else{%>
                                     <ul class="nav navbar-nav navbar-right">
                                         <li><a href="/sombra-shop-web-1.0.0/cart.jsp" >Cart</a></li>
                                     </ul>
                                <%}%>
                            <%}else{%>
                            <ul class="nav navbar-nav navbar-right">
                               <li><a href="registr.jsp">Sing Up</a></li>
                            </ul>
                            <ul class="nav navbar-nav navbar-right">
                               <li><a href="login.jsp">Log In</a></li>
                            </ul>
                            <%}%>
                        </div>
                    </nav>
                </div>

                <!-- End Header -->
        <!-- Start Main Page Content -->
        <div class="row" id="content-column">
            <center>
                   <p><img src='<%=session.getAttribute("imageItem")%>' style="width:450px;height:300px;"></p>
                   <p>
                     <%=session.getAttribute("nameItem")%>
                   <br>
                     <%=session.getAttribute("priceItem")%> $
                   </p>
                   <% if((session.getAttribute("cartList")!=null)&&(!(session.getAttribute("login").equals("admin")))){
                        List<Item> list = (ArrayList<Item>)session.getAttribute("cartList");
                                    if((list.size()>0)&&(list.get(list.size()-1).getId_item()==Integer.parseInt(session.getAttribute("idItem").toString()))){%>
                                        <p><a href="DeleteFromCartAllItemsServlet?index=<%=list.size()-1%>">Delete from cart</a></p>
                                    <%}else{ %>
                                        <p><a href='AddInCartListServlet?idItem=<%=session.getAttribute("idItem")%>'>Add to cart</a></p><%
                                    }
                      }
                   %>
            </center>
        </div>
        <!-- End Main Page Content -->








        <!-- Start Footer -->

        <div class="panel panel-default">
          <div class="panel-footer">&copy; 2016 SombraShop</div>
        </div>

        <!-- End Footer -->

    </div>
    <!-- End Container -->
</body>
</html>

