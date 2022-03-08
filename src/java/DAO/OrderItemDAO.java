/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Order;
import Model.OrderItems;
import MyUtils.ConnectionLib;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DINH
 */
public class OrderItemDAO {

    ConnectionLib cn = new ConnectionLib();
    Connection con;
    public ArrayList<OrderItems> getOrderItem(int ID) {
        ArrayList<OrderItems> list = new ArrayList<>();
        try {
           con =  cn.getConnectDB();

            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM orderitems WHERE orderitems.orderId = '" + ID + "'");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("orderId");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                int productId = rs.getInt("productId");
                list.add(new OrderItems(productId, quantity, price, productId));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

}
