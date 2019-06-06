package com.codecool.shop.dao;

import com.codecool.shop.dao.implementation.CartDaoMem;
import com.codecool.shop.model.Product;

import java.util.Map;

public interface CartDao {

    Map<Product, Integer> getAll();

    Integer getTotalValues();
    void addProduct(Product product);

    float getProductTotal(Product product);

    float getTotalOfAll();

}
