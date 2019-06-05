package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.CartDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.model.Product;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class CartDaoMem implements CartDao {

    ProductDao productDataStore = ProductDaoMem.getInstance();

    private HashMap<Product, Integer> cartData = new LinkedHashMap<>();
    private static CartDaoMem instance = null;

    private CartDaoMem() {
    }

    public static CartDaoMem getInstance() {
        if (instance == null) {
            instance = new CartDaoMem();
        }
        return instance;
    }

    @Override
    public HashMap<Product, Integer> getAll() {
        return cartData;
    }
}