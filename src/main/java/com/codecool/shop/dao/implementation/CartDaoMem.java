package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.CartDao;
import com.codecool.shop.model.Product;

import java.util.HashMap;
import java.util.Iterator;
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
    public void addOneProduct(Product product) {
        for (Product key : cartData.keySet()) {
            if (product.getName().equals(key.getName())) {
                cartData.put(key, cartData.get(key) + 1);
            }
        }
    }


//    for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) {
//        String value = iterator.next();
//        if (value.length() > 5) {
//            iterator.remove();
//        }
//    }


    @Override
    public void removeOneProduct(Product product) {
        for (Iterator<Product> iterator = cartData.keySet().iterator(); iterator.hasNext();){
            Product productIterator = iterator.next();
            if (productIterator.getName().equals(product.getName())) {
                if (cartData.get(product) <= 1) {
                    iterator.remove();
                } else {
                    cartData.put(product, cartData.get(product) - 1);
                }
            }
        }
    }

    @Override
    public float getProductTotal(Product product) {
        return product.getDefaultPrice() * cartData.get(product);
    }

    @Override
    public float getTotalOfAll() {
        float totalOfAll = 0;
        for (Product key : cartData.keySet()) {
            totalOfAll += getProductTotal(key);
        }

        return totalOfAll;
    }


}


