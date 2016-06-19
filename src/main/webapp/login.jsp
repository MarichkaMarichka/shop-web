<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="registr.jsp">Sing Up</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="login.jsp">Log In</a></li>
                    </ul>
                </div>
            </nav>
        </div>

        <!-- End Header -->
        <!-- Start Main Page Content -->

                <div class="row" id="content-column">
                    <div class="col-xs-4"></div>
                    <div class="col-xs-4">
                            <div class="form-group">
                                <center><h2>Login Form</h2></center>
                            </div>
                            <form action="LoginServlet" method="POST" class="form-horizontal">
                             <div class="form-group">
                              <label >Login</label>
                              <input name="login" class="form-control" placeholder="Login">

                             </div>



                             <div class="form-group">
                              <label for="pass" >Password</label>
                              <input name="pass" type="password" class="form-control" id="pass" placeholder="Password">


                               <div style="color:red">
                               <%if(session.getAttribute("myData")!=null){%>
                               <%= session.getAttribute("myData") %>
                               <%
                                session.setAttribute("myData", null) ;
                               }%>
                               </div>
                             </div>

                             <div class="form-group">
                              <div class="text-center">
                               <button type="submit" class="btn btn-success">Log In</button>
                              </div>
                             </div>
                            </form>

                    </div>
                    <div class="col-xs-4"></div>

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

