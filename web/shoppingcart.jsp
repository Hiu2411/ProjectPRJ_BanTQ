<%-- 
    Document   : shoppingcart
    Created on : Jun 22, 2020, 9:56:51 AM
    Author     : DINH
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="Controller.ProductModel"%>
<%@page import="Model.Item"%>
<%@page import="Model.Cart"%>
<%@page import="Model.Image"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Cart obj = new Cart();
    double total = 0;
    ProductModel pm = new ProductModel();
    ArrayList<Item> list = (ArrayList<Item>) session.getAttribute("cart");


%>

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
                        <li><a href="./index.jsp">Home</a></li>
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
                                <li   class="active"><a href="./shoppingcart.jsp">Shopping Cart</a></li>
                                <li ><a href="./checkout.jsp">Checkout</a></li>
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

    <!-- Breadcrumb Section Begin -->
    <div class="breacrumb-section">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb-text product-more">
                        <a href="./home.jsp"><i class="fa fa-home"></i> Home</a>
                        <a href="./shop.jsp">Shop</a>
                        <span>Shopping Cart</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb Section Begin -->

    <!-- Shopping Cart Section Begin -->
    <section class="shopping-cart spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">

                    <div class="cart-table">
                        <table>
                            <thead>
                                <tr>
                                    <th>Image</th>
                                    <th>Product Name</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th>Total</th>
                                    <th><i class="ti-close"></i></th>
                                </tr>
                            </thead>
                            <tbody>
                                <%for (Item item : list) {
                                    DecimalFormat formatter = new DecimalFormat("###,###,###");

                                 String price = formatter.format(item.getPrice());
                                 String price2 = formatter.format(item.getPrice() * item.getQuality());
                                %>
                            <td class="cart-pic"><img src="images/<%=pm.getImage(item.getProductId())%>.jpg" alt=""></td>
                            <td class="cart-title first-row">
                                <h5><%=item.getProductName()%></h5>
                            </td>
                            <td class="p-price first-row"><%=price%></td>
                            <td class="qua-col first-row">
                                <div class="quantity">
                                    <div >
                                        <a ><%=item.getQuality()%></a>
                                    </div>
                                </div>
                            </td>
                            <td class="total-price first-row"><%=price2%> vnd</td>
                            <%
                                total += item.getPrice()*item.getQuality();
                                
                            %>
                            <td class="close-td first-row">
                                <form action="CartDelete" method="POST">
                                <input hidden="" name="ID" value="<%=item.getProductId()%>">
                                <button type="submit" class="close-td first-row"><i class="ti-close"></i></button>
                                </form>
                            </td>
                            </tr>
                            <%}%>
                            </tbody>
                        </table>
                    </div>

                    <div class="row">
                        <div class="col-lg-4">
                            <div class="cart-buttons">
                                <a href="shop.jsp" class="primary-btn continue-shop">Continue shopping</a>
                                <a href="shoppingcart.jsp" class="primary-btn up-cart">Update cart</a>
                            </div>
                        </div>
                        <div class="col-lg-4 offset-lg-4">
                            <div class="proceed-checkout">
                                <ul>
                                    <%
                                    if(total>1000000){
                                        total=total*90/100;
                                        %>
                                    <li class="cart-total">Total is discounted 10%</li>
                                    <%}
                                        DecimalFormat formatter = new DecimalFormat("###,###,###");

                                         String price1 = formatter.format(total);
                                    %>
                                    <br>
                                    <li class="cart-total">Total <span><%=price1%> vnd</span></li>
                                </ul>
                                <a href="checkout.jsp" class="proceed-btn">PROCEED TO CHECK OUT</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Shopping Cart Section End -->


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