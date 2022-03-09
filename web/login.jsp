<%-- 
    Document   : login
    Created on : Jun 22, 2020, 9:54:33 AM
    Author     : DINH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                                <li><a href="./shoppingcart.jsp">Shopping Cart</a></li>
                                <li ><a href="./checkout.jsp">Checkout</a></li>
                                <li><a href="./Blog.jsp">Blog</a></li>
                                <li><a href="./register.jsp">Register</a></li>
                                <li   class="active"><a href="./login.jsp">Login</a></li>
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
                    <div class="breadcrumb-text">
                        <a href="#"><i class="fa fa-home"></i> Home</a>
                        <span>Login</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb Form Section Begin -->

    <!-- Register Section Begin -->
    <div class="register-login-section spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 offset-lg-3">
                    <div class="login-form">
                        <h2>Login</h2>
                        <form action="UserLoginServlet" method="POST">
                            <div class="group-input">
                                <label>Username *</label>
                                <input type="text" name="username">
                            </div>
                            <div class="group-input">
                                <label>Password *</label>
                                <input type="password" name="pass">
                            </div>
                            <button type="submit" class="site-btn login-btn">Sign In</button>
                        </form>
                        <script>

                            function statusChangeCallback(response) {  // Called with the results from FB.getLoginStatus().
                                console.log('statusChangeCallback');
                                console.log(response);                   // The current login status of the person.
                                if (response.status === 'connected') {   // Logged into your webpage and Facebook.
                                   
                                    testAPI();
                                } else {                                 // Not logged into your webpage or we are unable to tell.
                                    document.getElementById('status').innerHTML = 'Please log ' +
                                            'into this webpage.';
                                }
                            }


                            function checkLoginState() {               // Called when a person is finished with the Login Button.
                                FB.getLoginStatus(function (response) {   // See the onlogin handler
                                    statusChangeCallback(response);

                                });
                            }


                            window.fbAsyncInit = function () {
                                FB.init({
                                    appId: '{2665531046998908}',
                                    cookie: true, // Enable cookies to allow the server to access the session.
                                    xfbml: true, // Parse social plugins on this webpage.
                                    version: '{api-version}'           // Use this Graph API version for this call.
                                });


                                FB.getLoginStatus(function (response) {   // Called after the JS SDK has been initialized.
                                    statusChangeCallback(response);        // Returns the login status.
                                });
                            };

                            function testAPI() {                      // Testing Graph API after login.  See statusChangeCallback() for when this call is made.
                                console.log('Welcome!  Fetching your information.... ');
                                FB.api('/me', function (response) {
                                    console.log('Successful login for: ' + response.name);


                                    document.getElementById('status').innerHTML =
                                            'Thanks for logging in, ' + response.name + '!';
                                });
                            }

                        </script>


                        <!-- The JS SDK Login Button -->
                        <script async defer crossorigin="anonymous" src="https://connect.facebook.net/en_US/sdk.js#xfbml=1&version=v7.0&appId=2665531046998908" nonce="UpBS4Pet"></script>
                        <div class="fb-login-button" data-size="small" data-button-type="continue_with" data-layout="rounded" data-auto-logout-link="true" data-use-continue-as="true"  data-width="" ></div>


                        <div id="status">
                        </div>

                        <!-- Load the JS SDK asynchronously -->
                        <script async defer crossorigin="anonymous" src="https://connect.facebook.net/en_US/sdk.js"></script>
                        <div class="switch-login">
                            <a href="./register.jsp" class="or-login">Or Create An Account</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Register Form Section End -->



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