<%-- 
    Document   : ManagerProduct
    Created on : April 20, 2022, 9:51:14 PM
    Author     : hieuh
--%>


<%@page import="java.util.ArrayList"%>
<%@page import="Model.Product"%>
<%@page import="Controller.ProductModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("login")==null) {
        response.sendRedirect("loginAdmin.jsp");
        }else{
    ProductModel pm = new ProductModel();
    int p = 1;
    String s = "";
    String sortColumn = "";
    String name = "";

    if (request.getParameter("s") != null) {
        s = request.getParameter("s");
    }
    if (request.getParameter("username") != null) {
        name = request.getParameter("username");
    }
    if (request.getParameter("trang") != null) {
        p = Integer.parseInt(request.getParameter("trang"));
    }
    ArrayList<Product> list = pm.getPadding(p, s, sortColumn);
    int sp_no = (p - 1) * 10;
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shoes Shop</title>
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
                background-image: url("images/BGg.png");
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
                <h2 style="text-align: center; color: white;font-size: 50px" class="hihi">PRODUCTS</h2>       
                <h3 style="text-align: center; color: white;font-size: 40px" class="hihi">(Total product have : <%= pm.getNumberOfProduct(p, s, sortColumn)%>)</h3>
            </div>
           
            <br>
            <div>
                <table class="table table-bordered table-hover" >
                    <thead>
                    <form>
                        <div class="input-group">
                            <input type="text" class="form-control" placeholder="Search" name="s" value="<%=s%>">
                            <div class="input-group-btn">
                                <button class="btn btn-primary" type="submit" >
                                    <i class="glyphicon glyphicon-search"></i>
                                </button>
                            </div>
                        </div>
                    </form>
                    <tr>
                        <th colspan="9" align="center">
                            <%=pm.getPageString(p, s, sortColumn, name)%>
                        </th>
                    </tr>
                    <tr style="background: #4d72de">
                        <th>STT</th>
                        <th>Product Name</th>
                        <th>Product Image</th>
                        <th>Product Price</th>
                        <th>Product Size</th>
                        <th>Product Color</th>
                        <th>Product Satus</th>
                        <th>Product Type</th>
                        
                    </tr>
                    </thead>
                    <tbody>
                        <%
                            String status;
                            for (Product products : list) {
                                ++sp_no;
                                status = products.getStatus() != 1 ? "<span class='glyphicon glyphicon-remove-circle text-danger'></span>"
                                        : "<span class='glyphicon glyphicon-ok-circle text-success'></span>";
                        %>
                        <tr>
                            <td><%=sp_no%></td>
                            <td><%=products.getProductName()%></td>
                            <td><img class="img" src="images/<%=pm.getImage(products.getProductId())%>.jpg"></td>                  
                            <td><%=products.getPrice()%></td>
                            <td><%=products.getSize()%></td>
                            <td><%=products.getColor()%></td>
                            <td><%=status%></td>
                            <td><%=products.getTypeId()%></td>
                            
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
