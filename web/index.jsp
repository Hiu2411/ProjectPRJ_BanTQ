<%-- 
    Document   : index
    Created on : Jun 22, 2020, 8:51:02 AM
    Author     : DINH
--%>


<%@page import="Model.Item"%>
<%@page import="Model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Controller.ProductModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    
    ProductModel pm = new ProductModel();
    ArrayList<Product> list = pm.get3ProductByType(1);
    ArrayList<Product> list1 = pm.get3ProductByType(2);
    ArrayList<Product> list2 = pm.get3ProductByType(3);
%>

<!DOCTYPE html>

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Fashi Template">
    <meta name="keywords" content="Fashi, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>DITALO SHOES</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css?family=Muli:300,400,500,600,700,800,900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/themify-icons.css" type="text/css">
    <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="css/style1.css" type="text/css">
</head>

<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <!-- Header Section Begin -->
    <header class="header-section">
        <div class="header-top">
            <div class="container">
                <div class="ht-left">
                    <div class="mail-service">
                        <i class=" fa fa-envelope"></i>
                    </div>
                    <div class="phone-service">
                        <i class=" fa fa-phone"></i>
                    </div>
                </div>
                <div class="ht-right">
                    <a href="login.jsp" class="login-panel"><i class="fa fa-user"></i>Login</a>
                    <div class="top-social">
                        <a href=""><i class="ti-facebook"></i></a>
                        <a href="#"><i class="ti-twitter-alt"></i></a>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="inner-header">
                <div class="row">
                    <div class="col-lg-2 col-md-2">
                        <div class="logo">
                            <a href="./index.jsp">
                                <img src="img/logo.png" alt="">
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-7 col-md-7">
                        <div class="advanced-search">
                            <button type="button" class="category-btn">All Categories</button>
                            <div class="input-group">
                                <form method="post" action="Search.jsp">
                                <input type="text" name="txtSearch" placeholder="What do you need?">
                                <button type="submit" onclick="window.location.href='Search.jsp'"><i class="ti-search"></i></button>
                                </form>
                            </div>
                        </div>
                    </div>
                    
                </div>
            </div>
        </div>
        <div class="nav-item">
            <div class="container">
                <div class="nav-depart">
                    <div class="depart-btn">
                        <i class="ti-menu"></i>
                        <span>All departments</span>
                        </ul>
                    </div>
                </div>
                <nav class="nav-menu mobile-menu">
                    <ul>
                        <li class="active"><a href="./index.jsp">Home</a></li>
                        <li><a href="./shop.jsp">Shop</a></li>
                        <li><a href="#">Collection</a>
                            <ul class="dropdown">
                                <li><a href="colection.jsp?typeId=<%=1%>">Adidas Football Shoes</a></li>
                                 <li><a href="colection.jsp?typeId=<%=2%>">Nike Football Shoes</a></li>
                                <li><a href="colection.jsp?typeId=<%=3%>">Puma Football Shoes</a></li>
                            </ul>
                        </li>
                        <li><a href="#">Blog</a></li>
                        <li><a href="./contact.jsp">Contact</a></li>
                        <li><a href="#">Pages</a>
                            <ul class="dropdown">
                                <li><a href="./shoppingcart.jsp">Shopping Cart</a></li>
                                <li><a href="./checkout.jsp">Checkout</a></li>
                                <li><a href="./Blog.jsp">Blog</a></li>
                                <li><a href="./register.jsp">Register</a></li>
                                <li><a href="./login.jsp">Login</a></li>
                            </ul>
                        </li>
                    </ul>
                </nav>
                <div id="mobile-menu-wrap"></div>
            </div>
        </div>
    </header>
    <!-- Header End -->

    <!-- Hero Section Begin -->
    <section class="hero-section">
        <div class="hero-items owl-carousel">
            <div class="single-hero-items set-bg" data-setbg="img/hero-1.jpg">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-5">
                            <span>Bag,kids</span>
                            <h1>Black friday</h1>
                            <a href="./shop.jsp" class="primary-btn">Shop Now</a>
                        </div>
                    </div>
                    <div class="off-card">
                        <h2>Sale <span>50%</span></h2>
                    </div>
                </div>
            </div>
            <div class="single-hero-items set-bg" data-setbg="img/hero-2.jpg">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-5">
                            <span>Bag,kids</span>
                            <h1>Black friday</h1>
                            <a href="#" class="primary-btn">Shop Now</a>
                        </div>
                    </div>
                    <div class="off-card">
                        <h2>Sale <span>50%</span></h2>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Hero Section End -->

    <!-- Banner Section Begin -->
    <div class="banner-section spad">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-4">
                    <div class="single-banner">
                        <img  src="img/banner-1.jpg" alt="">
                        <div  class="inner-text">
                            <h4><a href="colection.jsp?typeId=<%=1%>" >Adidass</a></h4>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="single-banner">
                        <img  src="img/banner-2.jpg" alt="">
                        <div class="inner-text">
                            <h4><a href="colection.jsp?typeId=<%=2%>" >Nike</a></h4>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="single-banner">
                        <img  src="img/banner-3.jpg" alt="">
                        <div class="inner-text">
                            <h4><a href="colection.jsp?typeId=<%=3%>" >Puma</a></h4>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Banner Section End -->

    <!-- Women Banner Section Begin -->
    <section class="women-banner spad">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-3">
                    <div class="product-large set-bg" data-setbg="img/products/man-large.jpg">
                    </div>
                </div>
                <div class="col-lg-8">
                    <div class="filter-control">
                        <ul


                    </ul>
                </div>
                    <form action="CartServlet" method="POST">
                <div class="product-slider owl-carousel">
                    <%
                        for (int i = 0; i < list.size(); i++) {
                    %>
                    <div class="product-item">
                        <div class="pi-pic">
                            <img src="images/<%=pm.getImage(list.get(i).getProductId())%>.jpg" alt="">
                            <div class="icon">
                                <i class="icon_heart_alt"></i>
                            </div>
                        </div>
                        <div class="pi-text">
                            <div class="catagory-name">Coat</div>
                            <a href="product.jsp?pID=<%=list.get(i).getProductId()%>">
                                <h5><%=list.get(i).getProductName()%></h5>
                            </a>
                            <div class="product-price">
                                <%=list.get(i).getPrice()%> vnd
                            </div>
                        </div>
                    </div>
                    <%}%>
                </div> 
                </form>

            </div>
        </div>
    </div>
</section>
<!-- Women Banner Section End -->

<!-- Man Banner Section Begin -->
<section class="man-banner spad">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-8">
                <div class="filter-control">
                    <ul


                </ul>
            </div>

            <div class="product-slider owl-carousel">
                <%
                    for (int i = 0; i < list1.size(); i++) {
                %>
                <div class="product-item">
                    <div class="pi-pic">
                        <img src="images/<%=pm.getImage(list1.get(i).getProductId())%>.jpg" alt="">
                        <div class="icon">
                            <i class="icon_heart_alt"></i>
                        </div>
                    </div>
                    <div class="pi-text">
                        <div class="catagory-name">Coat</div>
                        <a href="product.jsp?pID=<%=list1.get(i).getProductId()%>">
                            <h5><%=list1.get(i).getProductName()%></h5>
                        </a>
                        <div class="product-price">
                            <%=list1.get(i).getPrice()%> vnd
                        </div>
                    </div>
                </div>
                <%}%>
            </div> 

        </div>
        <div class="col-lg-3 offset-lg-1">
            <div class="product-large set-bg m-large" data-setbg="img/products/women-large.jpg">
            </div>
        </div>
    </div>
</div>
</section>
<!-- Man Banner Section End -->


<!-- Kid Banner Section Begin -->
   <section class="women-banner spad">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-3">
                    <div class="product-large set-bg" data-setbg="img/products/man-large2.jpg">
                    </div>
                </div>
                <div class="col-lg-8">
                    <div class="filter-control">
                        <ul


                    </ul>
                </div>

                <div class="product-slider owl-carousel">
                    <%
                        for (int i = 0; i < list2.size(); i++) {
                    %>
                    <div class="product-item">
                        <div class="pi-pic">
                            <img src="images/<%=pm.getImage(list2.get(i).getProductId())%>.jpg" alt="">
                            <div class="icon">
                                <i class="icon_heart_alt"></i>
                            </div>
                        </div>
                        <div class="pi-text">
                            <div class="catagory-name">Coat</div>
                            <a href="product.jsp?pID=<%=list2.get(i).getProductId()%>">
                                <h5><%=list2.get(i).getProductName()%></h5>
                            </a>
                            <div class="product-price">
                                <%=list2.get(i).getPrice()%> vnd
                            </div>
                        </div>
                    </div>
                    <%}%>
                </div> 

            </div>
        </div>
    </div>
</section>
<!-- Kid Banner Section End -->

<!-- Footer Section Begin -->
<footer class="footer-section">
    <div class="container">
        <div class="row">
            <div class="col-lg-3">
                <div class="footer-left">
                    <div class="footer-logo">
                        <a href="#"><img src="img/logo.png" alt=""></a>
                    </div>
                    <ul>
                            <li>Address: Luong Son, Hoa Binh</li>
                        <li>Phone: +84 369730803</li>
                        <li>Email: hieutdce153410@fpt.edu.vn</li>
                        </ul>
                    <div class="footer-social">
                        <a href="#"><i class="fa fa-facebook"></i></a>
                        <a href="#"><i class="fa fa-instagram"></i></a>
                        <a href="#"><i class="fa fa-twitter"></i></a>
                    </div>
                </div>
            </div>
            <div class="col-lg-2 offset-lg-1">
                <div class="footer-widget">
                    <h5>Information</h5>
                    <ul>
                        <li><a href="more-about-us.html">About Us</a></li>
                        <li><a href="#">Contact</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-2">
                <div class="footer-widget">
                    <h5>My Account</h5>
                    <ul>
                        <li><a href="#">My Account</a></li>
                        <li><a href="#">Contact</a></li>
                        <li><a href="#">Shopping Cart</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="newslatter-item">
                    <h5>Join Our Pages Now</h5>
                    <p>Get E-mail updates about our latest shop and special offers.</p>
                    <form action="#" class="subscribe-form">
                        <input type="text" placeholder="Enter Your Mail">
                        <button type="button">Subscribe</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="copyright-reserved">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="copyright-text">
                        Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved
                    </div>
                    <div class="payment-pic">
                        <img src="img/payment-method.png" alt="">
                    </div>
                </div>
            </div>
        </div>
    </div>
</footer>
<!-- Footer Section End -->

<!-- Js Plugins -->
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery-ui.min.js"></script>
<script src="js/jquery.countdown.min.js"></script>
<script src="js/jquery.nice-select.min.js"></script>
<script src="js/jquery.zoom.min.js"></script>
<script src="js/jquery.dd.min.js"></script>
<script src="js/jquery.slicknav.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/main.js"></script>
</body>

</html>


