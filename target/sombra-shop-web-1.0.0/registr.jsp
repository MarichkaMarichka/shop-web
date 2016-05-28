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
        <div class="row" id="header">
            <div class="col-xs-4">
                <h1>SombraShop</h1>
            </div>
        </div>

        <!-- End Header -->
        <!-- Start Main Page Content -->

        <div class="row" id="content-column">
            <div class="col-xs-4"></div>
            <div class="col-xs-4">
                    <div class="form-group">
                        <center><h2>Registrarion form</h2></center>
                    </div>
                    <form action="RegServlet" method="POST" class="form-horizontal">
                     <div class="form-group">
                      <label >Login</label>
                      <input name="login" class="form-control" placeholder="Login">
                     </div>

                     <div class="form-group">
                       <label for="mail" >Email</label>
                       <input name="email" class="form-control" id="mail" placeholder="Email">
                     </div>

                     <div class="form-group">
                      <label for="pass" >Password</label>
                      <input name="pass" type="password" class="form-control" id="pass" placeholder="Password">
                     </div>

                     <div class="form-group">
                      <label for="pass" >Confirm Password</label>
                      <input name="submPass" type="password" class="form-control" id="pass" placeholder="Confirm password">
                      <%if(session.getAttribute("isEquals")!=null){%>
                        <%= session.getAttribute("isEquals") %>
                      <%}%>
                     </div>

                     <div class="form-group">
                       <label >Phone number</label>
                       <input name="number" class="form-control" placeholder="Phone number">
                       <%if(session.getAttribute("myData")!=null){%>
                       <%= session.getAttribute("myData") %>
                       <%}%>
                     </div>

                     <div class="form-group">
                      <div class="text-center">
                       <button type="submit" class="btn btn-success">Sing up</button>
                      </div>
                     </div>
                    </form>

            </div>
            <div class="col-xs-4"></div>

            </div>
        <!-- End Main Page Content -->
        <!-- Start Footer -->
        <div class="row" id="footer">

            <div class="col-xs-12">
                &copy; 2016 SombraShop
            </div>
        </div>
        <!-- End Footer -->

    </div>
    <!-- End Container -->
</body>
</html>

