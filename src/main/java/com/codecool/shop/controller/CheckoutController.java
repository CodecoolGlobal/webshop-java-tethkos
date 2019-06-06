package com.codecool.shop.controller;

import com.codecool.shop.dao.CartDao;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.CartDaoMem;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import com.codecool.shop.payment.Email;
import com.codecool.shop.payment.JsonConverter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


@WebServlet(urlPatterns = {"/checkout"})
public class CheckoutController extends HttpServlet {

    static ArrayList<String> userInformations = new ArrayList<String>();

    static public ArrayList<String> getUserInformation() {
        return userInformations;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CartDao cartDaoData = CartDaoMem.getInstance();

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("cartData", cartDaoData.getAll());
        context.setVariable("totalPrice", cartDaoData.getTotalOfAll());
        engine.process("product/checkout.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        CartDao cartDaoData = CartDaoMem.getInstance();
        ProductDao productDao = ProductDaoMem.getInstance();

        Map<Product, Integer> chartProducts = cartDaoData.getAll();


        String chartResult = "";


        for (Map.Entry<Product, Integer> entry : chartProducts.entrySet()) {
            Product products = entry.getKey();
            Integer entity = entry.getValue();

            chartResult += products.getName() + ": " + entity;
        }


        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String billingAddress = request.getParameter("billingAddress");
        String billingCity = request.getParameter("billingCity");
        String billingZip = request.getParameter("billingZip");

        String toEmail = "Name: " + name + " E-mail: " + email + " Phone number: " + phoneNumber + " City:" + billingCity + " Adress: " + billingAddress
                + " ZIP: " + billingZip + " Entity" + chartResult;

        CartController cartController = new CartController();


        Email emailSender = new Email();
        emailSender.send(toEmail, email);

        JsonConverter jsonConverter = new JsonConverter();
        jsonConverter.main(name, email, phoneNumber, email, billingCity, billingZip, billingAddress, chartResult);


        userInformations.add(name);
        userInformations.add(email);
        userInformations.add(phoneNumber);
        userInformations.add(billingAddress);
        userInformations.add(billingCity);
        userInformations.add(billingZip);
        userInformations.add(chartResult);


        cartDaoData.getAll().clear();
        response.sendRedirect("/");

    }


}


