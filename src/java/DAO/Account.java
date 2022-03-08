/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
     public boolean Login(String name, String pass) {
        boolean status = false;
        try {
            con =  cn.getConnectDB();
            PreparedStatement ps = con.prepareStatement(
                    "select * from customeraccount where username=? and password=?");
            ps.setString(1, name);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();
            status = rs.next();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return status;
    }
     public boolean Register(String name, String pass) {
        boolean status = false;
        try {
            con =  cn.getConnectDB();

            PreparedStatement ps = con.prepareStatement(
                   "INSERT INTO customeraccount (username, password, customerID) VALUES ('"+name+"', '"+MD5.MD5.MD5(pass)+"', '"+getID()+1+"');");
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
                   "SELECT MAX(customerID) FROM customeraccount");
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
     public boolean LoginAdmin(String name, String pass) {
        boolean status = false;
        try {
            con =  cn.getConnectDB();

            PreparedStatement ps = con.prepareStatement(
                    "select * from admin where username=? and password=?");
            ps.setString(1, name);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();
            status = rs.next();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return status;
    }
}
