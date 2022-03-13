/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Customer;
import MyUtils.ConnectionLib;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author DINH
 */
public class Account {
    ConnectionLib cn = new ConnectionLib();
    Connection con;
     public Customer Login(String name, String pass) {
         Customer cus = new Customer();
        try {
            con =  cn.getConnectDB();
            PreparedStatement ps = con.prepareStatement(
                    "SELECT TOP 1000 [customerId]\n" +
                    "      ,[fullName]\n" +
                    "      ,[address]\n" +
                    "      ,[email]\n" +
                    "      ,[gender]\n" +
                    "      ,[phone]\n" +
                    "      ,[username]\n" +
                    "      ,[password]\n" +
                    "      ,[roleID]\n" +
                    "      ,[status]\n" +
                    "  FROM [Project_PRJ].[dbo].[customer]\n" +
                    "  where username=? and password=?");
            ps.setString(1, name);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String username = rs.getString("username");
                int roleID = rs.getInt("roleID");
                cus.setUsername(username);
                cus.setRoleID(roleID);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cus;
    }
     public boolean Register(String name, String pass) {
        boolean status = false;
        try {
            con =  cn.getConnectDB();

            PreparedStatement ps = con.prepareStatement(
                   "INSERT INTO customer ([username], [password], [roleID],[status]) VALUES ('"+name+"', '"+pass+"', 2, 1);");
             ps.executeUpdate();
            status = true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return status;
    }
     public int getID(){
         int Id = 0;
        try {
            con =  cn.getConnectDB();

            PreparedStatement ps = con.prepareStatement(
                   "SELECT MAX(customerID) FROM customer");
            ResultSet rs = ps.executeQuery();
           Id = rs.getInt("MAX(customerID)");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Id+1;
     }
     public boolean Delete(String ID) {
        boolean status = false;
        try {
           
            con =  cn.getConnectDB();

            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM admin WHERE admin.adminId = '"+ID+"'");
             ps.executeUpdate();
            status = true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return status;
    }
}
