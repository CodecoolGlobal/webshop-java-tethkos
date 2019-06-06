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
    public CartDao addProduct(Product product) {
        if (cartData.containsKey(product)) {
            cartData.put(product, cartData.get(product) + 1);
        } else {
            cartData.put(product, 1);
        }
        return null;
    }

    @Override
    public CartDao removeProduct(Product product) {
        if (cartData.get(product) >= 1) {
            cartData.put(product, cartData.get(product) - 1);
        }
        else {
            cartData.remove(product);
        }
        return null;
    }

    @Override
    public float getProductTotal(Product product) {
        return product.getDefaultPrice() * cartData.get(product);
    }

    @Override
    public float getTotalOfAll() {
        float totalOfAll = 0;
        for (Product key : cartData.keySet()) {
            totalOfAll = +getProductTotal(key);
        }

        return totalOfAll;
    }


}


