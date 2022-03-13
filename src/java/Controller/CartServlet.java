/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Cart;
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
@WebServlet(name = "CartServlet", urlPatterns = {"/CartServlet"})
public class CartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        int productId = Integer.parseInt(request.getParameter("productId"));
        String productName = request.getParameter("productName");
        double price = Double.parseDouble(request.getParameter("price"));
        int size = Integer.parseInt(request.getParameter("size"));
        String color = request.getParameter("color");
        int typeId = Integer.parseInt(request.getParameter("typeId"));
        int quality = 1;
        double total = price;
        boolean check = false;
        int found = 0;

        ArrayList<Item> objCartBean = (ArrayList<Item>) session.getAttribute("cart");

        if (objCartBean != null) {
            for (int i = 0; i < objCartBean.size(); i++) {
                if (productId == objCartBean.get(i).getProductId()) {
                    check = true;
                    found = i;
                    break;
                }
            }
            if (check) {

                objCartBean.get(found).setQuality(objCartBean.get(found).getQuality() + 1);

            } else {
                objCartBean.add(new Item(productId, productName, price, size, color, typeId, quality, typeId));
            }

        } else {
            objCartBean = new ArrayList<>();
            session.setAttribute("cart", objCartBean);
            objCartBean.add(new Item(productId, productName, price, size, color, typeId, quality, typeId));
        }

        response.sendRedirect("shoppingcart.jsp");
    }
}
