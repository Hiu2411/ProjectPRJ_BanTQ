/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.OrderManage;
import Model.Item;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hieuh
 */
@WebServlet(name = "CheckoutServlet", urlPatterns = {"/CheckoutServlet"})
public class CheckoutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        OrderManage obj = null;
        try {
            obj = new OrderManage();
        } catch (SQLException ex) {
            Logger.getLogger(CheckoutServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        String fullname = request.getParameter("fullname");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        HttpSession session = request.getSession();
        ArrayList<Item> objCartBean = (ArrayList<Item>) session.getAttribute("cart");
        boolean isOrderItem = false;
        for (int i = 0; i < objCartBean.size(); i++) {
            isOrderItem = obj.Insertorderitems(obj.getOrderID(), objCartBean.get(i).getQuality(), objCartBean.get(i).getPrice(), objCartBean.get(i).getProductId());
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        boolean isOrder = obj.InsertOrder(obj.getOrderID(), obj.getID(), address, (String) formatter.format(date), (String) formatter.format(date), 1, 1, 1);

        boolean isCus = obj.InsertCustomer(obj.getID(), fullname, address, email, 1, phone, 1);

        if (isOrder && isOrderItem && isCus) {
            request.setAttribute("check", "Thank you for your Order!!! See you later");
            RequestDispatcher dispatcher = request.getRequestDispatcher("checkout.jsp");
            dispatcher.forward(request, response);
        }
    }
}
