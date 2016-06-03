<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="store.ItemsRepository" %>
<%@ page import="models.Item" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

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
                    <a href="#" class="navbar-brand">SombraShop</a>
                </div>
                <!-- Collection of nav links, forms, and other content for toggling -->
                <div id="navbarCollapse" class="collapse navbar-collapse">
                    <form role="search" class="navbar-form navbar-left">
                        <div class="form-group">
                            <input type="text" placeholder="Search" class="form-control">
                        </div>
                    </form>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="LogoutServlet" >Log Out</a></li>
                    </ul>
                </div>
            </nav>
        </div>

        <!-- End Header -->
         <div class="row" id="content-column">

         <%
            ItemsRepository storage = new ItemsRepository();
            List<Item> items = storage.selectItems(1,6);
            String name;
            Integer price;
            String image;
            for (Item i :items) {
            %>

                <!-- Start Main Page Content -->

                                  <div class="col-md-3">
                                    <div class="thumbnail">
                                      <img data-src="holder.js/100%x180" />
                                      <div class="caption">

                                        <a href="https://www.google.com.ua">
                                        <img src="<%= i.getImage()%>" alt="Lava GSM Mobile Phone" style="width:263px;height:180px;">
                                        <p>
                                            <%= i.getName()%>
                                        <br>
                                            <%= i.getPrice()%>$
                                        </p>
                                      </div>
                                    </div>
                                  </div>







           <% } %>
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

