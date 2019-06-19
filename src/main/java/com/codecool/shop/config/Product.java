package com.codecool.shop.config;

public class Product {

    String name;
    String defaultPrice;
    String currencystring;
    String description;
    String category;
    String artist;

    public Product(String name, String defaultPrice, String currencystring, String description, String category, String artist){
        {this.name = name; this.defaultPrice = defaultPrice; this.currencystring = currencystring; this.description = description;
        this.category = category; this.artist = artist;}
    }

}
