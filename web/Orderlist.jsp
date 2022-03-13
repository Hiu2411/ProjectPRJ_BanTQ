<%-- 
    Document   : Orderlist
    Created on : April 20, 2022, 9:51:14 PM
    Author     : hieuh
--%>



<%@page import="java.util.ArrayList"%>
<%@page import="Model.Order"%>
<%@page import="DAO.OrderManage"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    
    if (session.getAttribute("login")==null) {
        response.sendRedirect("loginAdmin.jsp");
        }else{


    OrderManage aam = new OrderManage();
    int p = 0;
    ArrayList<Order> list = aam.getOrders();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Order List</title>
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
            @-webkit-keyframes example {
                0%   {color: #1CDCE2FF;}
                25%  {color: #EDDB11FF;}
                50%  {color: #CB0FEFFF;}
                100% {color: green;}
            }
            @-webkit-keyframes exampleq {
                0%   {background-color: #1CDCE2FF;}
                25%  {background-color: #EDDB11FF;}
                50%  {background-color: #CB0FEFFF;}
                100% {background-color: green;}
            }
            .hihi{
                display: block;
                font-size: 30px;
                font-weight: 700;
                letter-spacing: 18px;
            }
        </style>
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
                    onclick="location.href = 'dashboard.jsp'">
                <span class="glyphicon glyphicon-menu-left"></span> Back
            </button>
            <div class="abc">
                <h2 style="text-align: center; color: white;font-size: 50px" class="hihi">ORDER LIST</h2>       
                <h3 style="text-align: center; color: white;font-size: 40px" class="hihi"></h3>
            </div>

            <br>
            <div>
                <table class="table table-bordered table-hover" >
                    <thead>
                        <tr style="background: #4d72de">
                            <th>STT</th>
                            <th>Customer Name</th>
                            <th>Address</th>
                            <th>Phone</th>
                            <th>DateBuy</th>
                            <th>Status</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            String status;
                            for (Order acc : list) {
                                if (acc.getStatus() == 1) {
                                    status = "Waitting Accept";
                                } else if (acc.getStatus() == 2) {
                                    status = "Accepted";
                                } else {
                                    status = "Cancelled";
                                }
                        %>
                        <tr>
                            <td><%=++p%></td>           
                            <td><%=aam.getNameCus(acc.getcustomerId())%></td>                         
                            <td><%=acc.getAddress()%></td>
                            <td><%=aam.getPhone(acc.getcustomerId())%></td>
                            <td><%=acc.getDateDone()%></td>
                            <td><%=status%></td>
                            <td>
                                <form action="OrderListServlet" method="POST">
                                    <input hidden="" name="orderID" value="<%=acc.getOrderId()%>">
                                    <button  type="submit" >
                                        &#10003;
                                    </button>

                                </form>

                            </td>
                            <td>

                                <form action="OrderCancel" method="POST">
                                    <input hidden="" name="orderID" value="<%=acc.getOrderId()%>">
                                    <button  type="submit" >
                                        &#10006;
                                    </button>
                                </form>

                            </td>
                            <td>
                                <button onclick="window.location.href = 'orderview.jsp?orderID=<%=acc.getOrderId()%>'" class="btn btn-default btn-sm btn-danger">
                                    <span class="glyphicon glyphicon-plus"></span> 
                                </button>
                            </td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
<%}%>
