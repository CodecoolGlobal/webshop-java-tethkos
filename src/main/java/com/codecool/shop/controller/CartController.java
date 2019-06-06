package com.codecool.shop.controller;


import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.CartDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.implementation.CartDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.model.Product;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(urlPatterns = {"/cart"})

public class CartController extends HttpServlet {

    private CartDao cartDaoData = CartDaoMem.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());

        context.setVariable("productsInCart", cartDaoData.getAll());

        engine.process("cart/cart.html", context, resp.getWriter());
    }

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException {
        ProductDao productDao = ProductDaoMem.getInstance();

        String[] productIdString = request.getParameterValues("productId");
        String minus = request.getParameter("remove");
        String plus = request.getParameter("add");

        if (request.getParameter().contains(minus)) {
            int productId = Integer.parseInt(String.valueOf(productIdString));
            CartDao removeProduct = cartDaoData.removeProduct(productDao.find(productId));
            response.sendRedirect("/cart");
        }
        else if (request.getParameter().contains(plus)) {
            int productId = Integer.parseInt(String.valueOf(productIdString));
            CartDao addProduct = cartDaoData.addProduct(productDao.find(productId));
            response.sendRedirect("/cart");
        }
    }
}
