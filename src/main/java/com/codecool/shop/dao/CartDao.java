package com.codecool.shop.dao;

import com.codecool.shop.model.Product;

import java.util.Map;

public interface CartDao {

    Map<Product, Integer> getAll();

    Integer getTotalValues();

    CartDao addProduct(Product product);

    CartDao removeProduct(Product product);

    float getProductTotal(Product product);

    float getTotalOfAll();

    void addOneProduct(Product product);

    void removeOneProduct(Product product);


}
