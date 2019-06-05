package com.codecool.shop.controller;

import com.codecool.shop.dao.CartDao;
import com.codecool.shop.dao.implementation.CartDaoMem;
import com.codecool.shop.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/addToCart"})
public class AddToCart extends HttpServlet {

    @Override
    protected void doPost
            (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CartDao cartDaoData = CartDaoMem.getInstance();

        Product product = (Product) request.getAttribute("product");
        cartDaoData.addProduct(product);
        response.sendRedirect("/");
    }

}
