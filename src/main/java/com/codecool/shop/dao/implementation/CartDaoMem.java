package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.CartDao;
import com.codecool.shop.model.Product;

import java.util.HashMap;
import java.util.Map;


public class CartDaoMem implements CartDao {

    private Map<Product, Integer> cartData = new HashMap<>();
    private static CartDaoMem instance = null;

    /* A private Constructor prevents any other class from instantiating.
     */
    private CartDaoMem() {
    }

    public static CartDaoMem getInstance() {
        if (instance == null) {
            instance = new CartDaoMem();
        }
        return instance;
    }

    @Override
    public Map<Product, Integer> getAll() {
        return cartData;
    }

    @Override
    public Integer getTotalValues() {
        int count = 0;
        for (Integer i : cartData.values()) {
            count += i;
            }
        return count;
        }


    @Override
    public void addProduct (Product product){
        if (cartData.containsKey(product)) {
            cartData.put(product, cartData.get(product) + 1);
        } else {
            cartData.put(product, 1);
        }

    @Override
    public Double getProductTotal(Product product) {
        Double productTotal = Double.parseDouble(product.getPrice()) * cartData.get(product);
        return productTotal;
    }

    @Override
    public Double getTotalOfAll() {
            Double totalOfAll = null;
            for (Product key : cartData.keySet()) {
                totalOfAll =+ getProductTotal(key);
            }

        return totalOfAll;
    }



