/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MyUtils.ConnectionLib;
import Model.AdminException;
import Model.Order;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author DINH
 */
public class OrderManage {

    ConnectionLib cn = new ConnectionLib();
    Connection con;
    public OrderManage() throws SQLException {
        try {
            con =  cn.getConnectDB();
            st = con.createStatement();
            pst = null;
            rs = null;
            query = null;
            acc = new ArrayList<>();
            //cost = new ArrayList<>();
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }
    public PreparedStatement pst;
    public ResultSet rs;
    static Statement st;
    public ArrayList<Order> acc;
    public String query;
    int numberPage = 10;

    public ArrayList<Order> getOrders() throws SQLException, AdminException {
        String sqlStr = "";
        sqlStr += "SELECT * FROM orderShoes";

        st = this.con.createStatement();
        rs = this.st.executeQuery(sqlStr);
        acc = new ArrayList<>();

        while (rs.next()) {
            int id = rs.getInt("orderId");
            int cusID = rs.getInt("customerId");
            String add = rs.getString("address");
            String dateBuy = rs.getString("dateBuy");
            String dateDone = rs.getString("dateDone");
            int paymentId = rs.getInt("paymentId");
            int transportId = rs.getInt("transportId");
            int status = rs.getInt("status");
            if (status != 0) {
                acc.add(new Order(id, cusID, add, dateBuy, dateDone, paymentId, transportId, status));
            }

        }

        return this.acc;
    }

    public String getNameCus(int ID) {
        String name = null;
        try {
            con =  cn.getConnectDB();

            PreparedStatement ps = con.prepareStatement(
                    "select * from customer where customerID=" + ID + "");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                name = rs.getString("fullName");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return name;
    }

    public String getPhone(int ID) {
        String name = null;
        try {
            con =  cn.getConnectDB();

            PreparedStatement ps = con.prepareStatement(
                    "select * from customer where customerID=" + ID + "");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                name = rs.getString("phone");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return name;
    }

    public int getOrderID() {
        int Id = 0;
        try {
            con =  cn.getConnectDB();

            PreparedStatement ps = con.prepareStatement(
                    "SELECT MAX(order.orderId) FROM order");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Id = rs.getInt("MAX(order.orderId)");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Id + 1;
    }

    public boolean Insertorderitems(int orderId, int quantity, double price, int productId) {
        boolean status = false;
        try {
            con =  cn.getConnectDB();

            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO orderitems (orderId, quantity, price, productId) VALUES ('" + orderId + "', '" + quantity + "', '" + price + "', '" + productId + "')");
            ps.executeUpdate();
            status = true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return status;
    }

    public boolean InsertCustomer(int customerId, String fullName, String address, String email, int gender, String phone, int status) {
        boolean check = false;
        try {
            con =  cn.getConnectDB();

            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO customer (customerId, fullName, address, email, gender, phone, status) VALUES ('" + customerId + "', '" + fullName + "', '" + address + "', '" + email + "', '" + gender + "', '" + phone + "', '" + status + "');");
            ps.executeUpdate();
            check = true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return check;
    }

    public boolean InsertOrder(int orderId, int customerId, String address, String dateBuy, String dateDone, int paymentId, int transportId, int status) {
        boolean check = false;
        try {
            con =  cn.getConnectDB();

            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO order (orderId, customerId, address, dateBuy, dateDone, paymentId, transportId, status) VALUES ('" + orderId + "', '" + customerId + "', '" + address + "', '" + dateBuy + "', '" + dateDone + "', '" + paymentId + "', '" + transportId + "', '" + status + "')");
            ps.executeUpdate();
            check = true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return check;
    }

    public int getID() {
        int Id = 0;
        try {
            con =  cn.getConnectDB();

            PreparedStatement ps = con.prepareStatement(
                    "SELECT MAX(customerID) FROM customer");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Id = rs.getInt("MAX(customerID)");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Id + 1;
    }

}
