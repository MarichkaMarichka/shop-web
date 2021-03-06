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
                    <ul class="dropdown-menu" aria-labelledby="dropdownMenu4">
                      <li><a href="#">Regular link</a></li>
                      <li class="disabled"><a href="#">Disabled link</a></li>
                      <li><a href="#">Another link</a></li>
                    </ul>
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
                    <div class="col-xs-12">
                        <a href="add.jsp" class="btn ">Add Element</a>
                        <a href="AdminSelectServlet" class="btn ">List of elements</a>
                    </div>
                    <div class="col-xs-4">
                          	<form action="AddItemServlet" method="POST" class="form-horizontal">
                            	<input name="nameItem" class="form-control" placeholder="Name">
                            	<br>
                            	<input name="priceItem" class="form-control" placeholder="Price">
                            	<br>
                            	<input name="imageItem" class="form-control" placeholder="Image">
                            	<br>
                            	<button type="submit" class="btn btn-success">Add</button>
                            </form>
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

