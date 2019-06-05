package com.codecool.shop.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/addToCart"})
public class AddToCart {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CartDao cartDaoData = CartDaoMem.getInstance();

        Integer addId = Integer.parseInt(request.getParameter("product_id"));
        cartDaoData.addProductToShoppingCart(addId);
        response.sendRedirect("/");
    }

}
