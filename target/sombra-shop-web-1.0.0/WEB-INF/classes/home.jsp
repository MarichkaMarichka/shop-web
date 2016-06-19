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
                <c:forEach var="item" items="${itemList}">

                                  <div class="col-md-3">
                                    <div class="thumbnail">
                                      <img data-src="holder.js/80%x160" />
                                      <div class="caption">


                                        <p><a href="DescriptServlet?idItem=${item.getId_item()}"><img src="${item.getImage()}" style="width:233px;height:150px;"></a></p>
                                        <p>
                                            ${item.getName()}
                                        <br>
                                            ${item.getPrice()} $
                                        </p>
                                      </div>
                                    </div>
                				</div>
                 </c:forEach>







        <div class="col-md-12 text-center">

         <nav class="navigation">
           <ul class="pagination">



           	<c:if test="${currentPage != 1}">
           	<li class="page-item ">
           	    <a class="page-link" href="SelectServlet?page=${currentPage - 1}" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                    <span class="sr-only">Previous</span>
                </a>
            </li>

           	</c:if>

           	<%--For displaying Page numbers.
           	The when condition does not display a link for the current page--%>

           			<c:forEach begin="1" end="${noOfPages}" var="i">
           				<c:choose>
           					<c:when test="${currentPage eq i}">
           						<li class="page-item active">
                                   <a class="page-link" href="#" >${i} <span class="sr-only">(current)</span></a>
                                </li>
           					</c:when>
           					<c:otherwise>
           					    <li class="page-item"><a class="page-link" href="SelectServlet?page=${i}">${i}</a></li>
           					</c:otherwise>
           				</c:choose>
           			</c:forEach>


           	<%--For displaying Next link --%>
           	<c:if test="${currentPage lt noOfPages}">
           		<li class="page-item ">
                   <a class="page-link" href="SelectServlet?page=${currentPage + 1}" aria-label="Next">
                      <span aria-hidden="true">&raquo;</span>
                      <span class="sr-only">Next</span>
                   </a>
                </li>
           	</c:if>



            </li>
           </ul>
         </nav>

         </div>
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

