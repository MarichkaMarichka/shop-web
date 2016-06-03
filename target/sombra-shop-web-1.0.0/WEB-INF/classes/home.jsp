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





        <!-- Start Main Page Content -->
                <div class="row">
                  <div class="col-md-3">
                    <div class="thumbnail">
                      <img data-src="holder.js/100%x180" />
                      <div class="caption">
                        <a href="http://www.w3schools.com">
                        <img src="http://stat.homeshop18.com/homeshop18/images/productImages/274/lava-iris-x5-dual-sim-android-mobile-phone-large_4e574328198102ed9804b0fd99c2d60b.jpg" alt="Lava GSM Mobile Phone" style="width:263px;height:180px;">
                        <p>
                          <a href="#" class="btn btn-success" role="button">Like</a>
                          <a href="#" class="btn btn-danger" role="button">Dislike</a>
                        </p>
                      </div>
                    </div>
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

