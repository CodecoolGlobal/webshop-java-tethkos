package com.codecool.shop.dao;

import com.codecool.shop.model.Product;

import java.util.Map;

public interface CartDao {

    Map<Product, Integer> getAll();
    void addProduct(Product product);

}
