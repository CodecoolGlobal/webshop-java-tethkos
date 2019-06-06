package com.codecool.shop.payment;


import java.io.FileWriter;
import java.io.IOException;

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
    public void main(String name, String email, String phoneNumber, String country, String city, String zipcode, String adress) throws IOException {

        int id = (int) (System.currentTimeMillis() & 0xfffffff);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.now();
        String currentDate = dtf.format(localDate);

        String txtName = "/home/gergo/Desktop/"+ currentDate+"..."+id +".txt";


        JSONObject obj = new JSONObject();
        obj.put("E-mail", email);
        obj.put("Phone number", phoneNumber);
        obj.put("Country", country);
        obj.put("City", city);
        obj.put("Zipcode", zipcode);
        obj.put("Adress", adress);
        obj.put("Name", name);









        JSONArray company = new JSONArray();
        company.add("Compnay: eBay");
        company.add("Compnay: Paypal");
        company.add("Compnay: Google");
        obj.put("Company List", company);

        // try-with-resources statement based on post comment below :)
        try (FileWriter file = new FileWriter(txtName)) {
            file.write(obj.toJSONString());
            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("\nJSON Object: " + obj);
        }
    }


}
