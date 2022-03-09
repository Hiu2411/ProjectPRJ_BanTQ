<%-- 
    Document   : Orderlist
    Created on : Jul 19, 2020, 1:40:52 PM
    Author     : DINH
--%>




<%@page import="java.util.ArrayList"%>
<%@page import="Model.Admin"%>
<%@page import="DAO.account_adminModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    account_adminModel aam = new account_adminModel();
    int p = 1;
    String s = "";
    String sortColumn = "";
    String name = "";
    ArrayList<Admin> list = aam.getPadding(p, s, sortColumn);
    int sp_no = (p - 1) * 10;
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Account</title>
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
                <h2 style="text-align: center; color: white;font-size: 50px" class="hihi">EMPLOYEE ACCOUNT</h2>       
                <h3 style="text-align: center; color: white;font-size: 40px" class="hihi">( Total account : <%= aam.getNumberOfAcc(p, s, sortColumn)%>)</h3>
            </div>

            <br>
            <div>
                <table class="table table-bordered table-hover" >
                    <thead>
                    <form>
                        <div class="input-group">
                            <input type="text" class="form-control" placeholder="Search" name="s" value="<%=s%>">
                            <div class="input-group-btn">
                                <button class="btn btn-primary" type="submit">
                                    <i class="glyphicon glyphicon-search"></i>
                                </button>
                            </div>
                        </div>
                    </form>
                    <tr>
                        <th colspan="9" align="center">
                            <%=aam.getPageString(p, s, sortColumn, name)%>
                        </th>
                    </tr>
                    <tr style="background: #4d72de">
                        <th>STT</th>
                        <th>Full name</th>
                        <th>Username</th>
                        <th>Email</th>
                        <th>Status</th>
                        <th>
                            <button type="button" class="btn btn-warning btn-sm"
                                    onclick="location.href = 'admin-register.jsp?username=<%=name%>&s=<%=s%>&trang=<%=p%>'">
                                <span class="glyphicon glyphicon-plus"></span>
                            </button>
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                        <%
                            String status;
                            for (Admin acc : list) {
                                ++sp_no;
                                if (acc.getStatus() == 1) {
                                    status = "<span class='glyphicon glyphicon-user text-success'></span>";
                                } else if (acc.getStatus() == 2) {
                                    status = "<span class='glyphicon glyphicon-user text-warning'></span>";
                                } else {
                                    status = "<span class='glyphicon glyphicon-remove-circle text-danger'></span>";
                                }
                        %>
                        <tr>
                            <td><%=sp_no%></td>
                            <td><%=acc.getFullName()%></td>              
                            <td><%=acc.getUsername()%></td>                         
                            <td><%=acc.getEmail()%></td>
                            <td><%=status%></td>
                            <td>
                                
                                <input hidden="" name="ID" value="<%=acc.getAdminId()%>">
                                <button type="button" class="btn btn-default btn-sm btn-danger"
                                        
                                        onclick="if (confirm('Do you want do delete <%=acc.getUsername()%> ?'))
                                                    location.href = 'AccountDelete'">
                                    <span class="glyphicon glyphicon-trash "></span> 
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
