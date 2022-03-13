/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Item;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "CartDelete", urlPatterns = {"/CartDelete"})
public class CartDelete extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int Id = Integer.valueOf(request.getParameter("ID"));
        HttpSession session = request.getSession();
        ArrayList<Item> objCartBean = (ArrayList<Item>) session.getAttribute("cart");
        for (int i = 0; i < objCartBean.size(); i++) {
            if (Id==objCartBean.get(i).getProductId()) {
                objCartBean.remove(i);
            }
        }
        response.sendRedirect("shoppingcart.jsp");
    }

}
