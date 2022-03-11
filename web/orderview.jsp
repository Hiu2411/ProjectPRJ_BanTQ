<%-- 
    Document   : orderview
    Created on : Jul 21, 2020, 9:03:52 PM
    Author     : DINH
--%>

<%@page import="Controller.ProductModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.OrderItems"%>
<%@page import="DAO.OrderItemDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    
    if (session.getAttribute("login")==null) {
        response.sendRedirect("loginAdmin.jsp");
        }else{


    double total = 0;
    int ID = Integer.valueOf(request.getParameter("orderID"));
    ProductModel pm = new ProductModel();
    OrderItemDAO od = new OrderItemDAO();
    ArrayList<OrderItems> list = od.getOrderItem(ID);

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Order View</title>

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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

        <style>
            .img{
                width: 64px;
                height: 64px;
            }
            body{
                background-color: #f8f9fc;
            }
            .abc{
                background-image: url("images/BGA.jpg")
            }
        </style>
    </head>
    <body>

        <div class="container">  
            <button type="button" class="btn btn-default  btn-primary" 
                    onclick="location.href = 'Orderlist.jsp'">
                <span class="glyphicon glyphicon-menu-left"></span> Back
            </button>
            <div class="abc">
                <h2 style="text-align: center; color: white;font-size: 50px" class="hihi">Order View</h2>       
                <h3 style="text-align: center; color: white;font-size: 40px" class="hihi"></h3>
            </div>


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
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            for (int i = 0; i < list.size(); i++) {

                                        %>
                                    <td class="cart-pic"><img src="images/<%=pm.getImage(list.get(i).getProductId())%>.jpg" alt=""></td>
                                    <td class="cart-title first-row">
                                        <h5><center><%=pm.getProductNameById(list.get(i).getProductId())%></center></h5>
                                    </td>
                                    <td class="p-price first-row"><%=list.get(i).getPrice()%></td>
                                    <td class="qua-col first-row">
                                        <div class="quantity">
                                            <div >
                                                <a ><%=list.get(i).getQuantity()%></a>
                                            </div>
                                        </div>
                                    </td>
                                    <td class="total-price first-row"><%=list.get(i).getPrice() * list.get(i).getQuantity()%></td>
                                    <%
                                        total += list.get(i).getPrice() * list.get(i).getQuantity();
                                    %>
                                    </tr>
                                    <%}%>
                                    </tbody>
                                </table>
                            </div>

                            <div class="row">
                                <div class="col-lg-4 offset-lg-4">
                                    <div class="proceed-checkout">
                                        <ul>
                                            <li class="cart-total">Total <span><%=total%></span></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
    </body>
</html>
<%}%>
