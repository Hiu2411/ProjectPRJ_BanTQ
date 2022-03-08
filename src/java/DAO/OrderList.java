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
public class OrderList {
    ConnectionLib cn = new ConnectionLib();
    Connection con;
    public boolean Accept(int ID){
        boolean check = false;
                try {
            con =  cn.getConnectDB();

            PreparedStatement ps = con.prepareStatement(
                    "UPDATE orderShoes SET status = '2' WHERE orderShoes.orderId = '"+ID+"'");
            
            ps.executeUpdate();
            check = true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
                
                
        return check;
    }
    public boolean Cancel(int ID){
        boolean check = false;
                try {
           con =  cn.getConnectDB();

            PreparedStatement ps = con.prepareStatement(
                    "UPDATE orderShoes SET status = '3' WHERE orderShoes.orderId = '"+ID+"'");
            
            ps.executeUpdate();
            check = true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
                
                
        return check;
    }
}
