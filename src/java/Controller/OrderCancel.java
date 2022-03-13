/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.OrderList;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hieuh
 */
@WebServlet(name = "OrderCancel", urlPatterns = {"/OrderCancel"})
public class OrderCancel extends HttpServlet {
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        OrderList obj = new OrderList();

        int Id = Integer.valueOf(request.getParameter("orderID"));

        boolean check = obj.Cancel(Id);
        if (check) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("Orderlist.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("Orderlist.jsp");
            dispatcher.forward(request, response);
        }

    }

}
