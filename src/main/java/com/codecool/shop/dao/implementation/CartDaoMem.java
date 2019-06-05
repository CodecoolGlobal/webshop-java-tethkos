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


        public Map<Product, Integer> getAll() {
            return cartData;
        }


}
