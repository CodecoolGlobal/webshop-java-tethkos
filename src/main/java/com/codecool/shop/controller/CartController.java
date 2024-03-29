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

@WebServlet(urlPatterns = {"/cart"})

public class CartController extends HttpServlet {

    private CartDao cartDaoData = CartDaoMem.getInstance();
    CartDao cartDaoItems = CartDaoMem.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());

        context.setVariable("productsInCart", cartDaoData.getAll());
        context.setVariable("items", cartDaoItems.getTotalValues());
        context.setVariable("totalPrice", cartDaoData.getTotalOfAll());

        engine.process("cart/cart.html", context, resp.getWriter());
    }

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException {
        ProductDao productDao = ProductDaoMem.getInstance();

        String removeProduct = request.getParameter("removeOneProduct");
        String addProduct = request.getParameter("addOneProduct");


        if (removeProduct != null) {
            int productToRemoveId = Integer.parseInt(removeProduct);
            Product productToRemove = productDao.find(productToRemoveId);
            cartDaoData.removeProduct(productToRemove);
        }

        if (addProduct != null) {
            int productToAddId = Integer.parseInt(addProduct);
            Product productToAdd = productDao.find(productToAddId);
            cartDaoData.addProduct(productToAdd);
        }
        response.sendRedirect("/cart");
    }
}
