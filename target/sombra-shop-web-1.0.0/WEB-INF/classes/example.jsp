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
    <link rel='stylesheet' href='webjars/jquery/1.10.2/jquery.min.js'>
    <link rel="stylesheet" type="text/css" href="styles.css" />

</head>
<body>

<!-- Start Container -->
    <div class="container">

        <!-- Start Header -->
			<nav role="navigation" class="navbar navbar-default">
              <!-- Brand and toggle get grouped for better mobile display -->
              <div class="navbar-header">
                <button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle">
                  <span class="sr-only">Toggle navigation</span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                </button>
                <a href="#" class="navbar-brand">Бренд</a>
              </div>
              <!-- Collection of nav links, forms, and other content for toggling -->
              <div id="navbarCollapse" class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                  <li class="active"><a href="#">Главная</a></li>
                  <li><a href="#">Статьи</a></li>
                  <li class="dropdown">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">Новости <b class="caret"></b></a>
                    <ul role="menu" class="dropdown-menu">
                      <li><a href="#">Windows</a></li>
                      <li><a href="#">Mac OS</a></li>
                      <li><a href="#">Linux</a></li>
                      <li class="divider"></li>
                      <li><a href="#">Другие системы</a></li>
                    </ul>
                  </li>
                </ul>
                <form role="search" class="navbar-form navbar-left">
                  <div class="form-group">
                    <input type="text" placeholder="Найти" class="form-control">
                  </div>
                </form>
                <ul class="nav navbar-nav navbar-right">
                  <li><a href="#">Войти</a></li>
                </ul>
              </div>
            </nav>

        <!-- End Header -->
        <!-- Start Main Page Content -->

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

