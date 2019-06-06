package com.codecool.shop.payment;


import java.io.FileWriter;
import java.io.IOException;

import com.codecool.shop.dao.CartDao;
import com.codecool.shop.dao.implementation.CartDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.time.LocalDate;

/**
 * @author Crunchify.com
 */

public class JsonConverter {

    @SuppressWarnings("unchecked")
    public void main(String name, String email, String phoneNumber, String country, String city, String zipcode, String adress, String entity) throws IOException {

        int id = (int) (System.currentTimeMillis() & 0xfffffff);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.now();
        String currentDate = dtf.format(localDate);

        String txtName = "src/orders" + currentDate + "..." + id + ".txt";


        JSONObject obj = new JSONObject();
        obj.put("E-mail", email);
        obj.put("Phone number", phoneNumber);
        obj.put("Country", country);
        obj.put("City", city);
        obj.put("Zipcode", zipcode);
        obj.put("Adress", adress);
        obj.put("Name", name);
        obj.put("Entity", entity);

        try (FileWriter file = new FileWriter(txtName)) {
            file.write(obj.toJSONString());
            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("\nJSON Object: " + obj);


        }
    }


}
