package com.codecool.shop.config;

import com.codecool.shop.dao.CartDao;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.CartDaoMem;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class Initializer implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();
        CartDao cartDaoData = CartDaoMem.getInstance();

        //setting up a new supplier
        Supplier allSupplier = new Supplier("All Artists", "All");
        supplierDataStore.add(allSupplier);
        Supplier pony = new Supplier("Pony Wave", "When it comes to realistic tattoos, this artist is on a whole other level.");
        supplierDataStore.add(pony);
        Supplier bang = new Supplier("Bang Bang", "Bang Bang is a popular tattoo artist based in Terézcity");
        supplierDataStore.add(bang);
        Supplier johnny = new Supplier("Little Johnny", "The Terezcity-based artist specializes in highly intricate black-and-white tattoos with a lot of contrast.");
        supplierDataStore.add(johnny);
        Supplier ritkit = new Supplier("Rit Kit Tattoo", "She achieves her “live leaf tattoos” by using ink to first stamp the outline ");
        supplierDataStore.add(ritkit);


        //setting up a new product category
        ProductCategory allCategory = new ProductCategory("All Category", "all", "all");
        productCategoryDataStore.add(allCategory);
        ProductCategory famousPeople = new ProductCategory("Famous people", "Tattoo", "");
        productCategoryDataStore.add(famousPeople);
        ProductCategory makeup = new ProductCategory("Makeup", "Tattoo", "");
        productCategoryDataStore.add(makeup);
        ProductCategory calligraphic = new ProductCategory("Calligraphic", "Tattoo", "");
        productCategoryDataStore.add(calligraphic);
        ProductCategory realistic = new ProductCategory("Realistic", "Tattoo", "");
        productCategoryDataStore.add(realistic);
        ProductCategory couple = new ProductCategory("For trve lovers", "Tattoo", "");
        productCategoryDataStore.add(couple);


        //setting up products and printing it

        SqlInitalizer sqlInitalizer = new SqlInitalizer();


        for (int i = 0; i < sqlInitalizer.all().size(); i++) {


            if ((sqlInitalizer.all().get(i).artist).equals("Pony Wave")) {

                if (sqlInitalizer.all().get(i).category.equals("Famous people")) {
                    productDataStore.add(new Product(sqlInitalizer.all().get(i).name, Float.parseFloat(sqlInitalizer.all().get(i).defaultPrice), sqlInitalizer.all().get(i).currencystring, sqlInitalizer.all().get(i).description, famousPeople, pony));
                }

                if (sqlInitalizer.all().get(i).category.equals("Makeup")) {
                    productDataStore.add(new Product(sqlInitalizer.all().get(i).name, Float.parseFloat(sqlInitalizer.all().get(i).defaultPrice), sqlInitalizer.all().get(i).currencystring, sqlInitalizer.all().get(i).description, makeup, pony));
                }
                if (sqlInitalizer.all().get(i).category.equals("Calligraphic")) {
                    productDataStore.add(new Product(sqlInitalizer.all().get(i).name, Float.parseFloat(sqlInitalizer.all().get(i).defaultPrice), sqlInitalizer.all().get(i).currencystring, sqlInitalizer.all().get(i).description, calligraphic, pony));
                }

                if (sqlInitalizer.all().get(i).category.equals("Realistic")) {
                    productDataStore.add(new Product(sqlInitalizer.all().get(i).name, Float.parseFloat(sqlInitalizer.all().get(i).defaultPrice), sqlInitalizer.all().get(i).currencystring, sqlInitalizer.all().get(i).description, realistic, pony));
                }

                if (sqlInitalizer.all().get(i).category.equals("For trve lovers")) {
                    productDataStore.add(new Product(sqlInitalizer.all().get(i).name, Float.parseFloat(sqlInitalizer.all().get(i).defaultPrice), sqlInitalizer.all().get(i).currencystring, sqlInitalizer.all().get(i).description, couple, pony));
                }
            }

            if (sqlInitalizer.all().get(i).artist.equals("Bang Bang")) {
                if (sqlInitalizer.all().get(i).category.equals("Famous people")) {
                    productDataStore.add(new Product(sqlInitalizer.all().get(i).name, Float.parseFloat(sqlInitalizer.all().get(i).defaultPrice), sqlInitalizer.all().get(i).currencystring, sqlInitalizer.all().get(i).description, famousPeople, bang));
                }

                if (sqlInitalizer.all().get(i).category.equals("Makeup")) {
                    productDataStore.add(new Product(sqlInitalizer.all().get(i).name, Float.parseFloat(sqlInitalizer.all().get(i).defaultPrice), sqlInitalizer.all().get(i).currencystring, sqlInitalizer.all().get(i).description, makeup, bang));
                }
                if (sqlInitalizer.all().get(i).category.equals("Calligraphic")) {
                    productDataStore.add(new Product(sqlInitalizer.all().get(i).name, Float.parseFloat(sqlInitalizer.all().get(i).defaultPrice), sqlInitalizer.all().get(i).currencystring, sqlInitalizer.all().get(i).description, calligraphic, bang));
                }

                if (sqlInitalizer.all().get(i).category.equals("Realistic")) {
                    productDataStore.add(new Product(sqlInitalizer.all().get(i).name, Float.parseFloat(sqlInitalizer.all().get(i).defaultPrice), sqlInitalizer.all().get(i).currencystring, sqlInitalizer.all().get(i).description, realistic, bang));
                }

                if (sqlInitalizer.all().get(i).category.equals("For trve lovers")) {
                    productDataStore.add(new Product(sqlInitalizer.all().get(i).name, Float.parseFloat(sqlInitalizer.all().get(i).defaultPrice), sqlInitalizer.all().get(i).currencystring, sqlInitalizer.all().get(i).description, couple, bang));
                }
            }


            if (sqlInitalizer.all().get(i).artist.equals("Little Johnny")) {
                if (sqlInitalizer.all().get(i).category.equals("Famous people")) {
                    productDataStore.add(new Product(sqlInitalizer.all().get(i).name, Float.parseFloat(sqlInitalizer.all().get(i).defaultPrice), sqlInitalizer.all().get(i).currencystring, sqlInitalizer.all().get(i).description, famousPeople, johnny));
                }

                if (sqlInitalizer.all().get(i).category.equals("Makeup")) {
                    productDataStore.add(new Product(sqlInitalizer.all().get(i).name, Float.parseFloat(sqlInitalizer.all().get(i).defaultPrice), sqlInitalizer.all().get(i).currencystring, sqlInitalizer.all().get(i).description, makeup, johnny));
                }
                if (sqlInitalizer.all().get(i).category.equals("Calligraphic")) {
                    productDataStore.add(new Product(sqlInitalizer.all().get(i).name, Float.parseFloat(sqlInitalizer.all().get(i).defaultPrice), sqlInitalizer.all().get(i).currencystring, sqlInitalizer.all().get(i).description, calligraphic, johnny));
                }

                if (sqlInitalizer.all().get(i).category.equals("Realistic")) {
                    productDataStore.add(new Product(sqlInitalizer.all().get(i).name, Float.parseFloat(sqlInitalizer.all().get(i).defaultPrice), sqlInitalizer.all().get(i).currencystring, sqlInitalizer.all().get(i).description, realistic, johnny));
                }

                if (sqlInitalizer.all().get(i).category.equals("For trve lovers")) {
                    productDataStore.add(new Product(sqlInitalizer.all().get(i).name, Float.parseFloat(sqlInitalizer.all().get(i).defaultPrice), sqlInitalizer.all().get(i).currencystring, sqlInitalizer.all().get(i).description, couple, johnny));
                }
            }

            if (sqlInitalizer.all().get(i).artist.equals("Rit Kit Tattoo")) {
                if (sqlInitalizer.all().get(i).category.equals("Famous people")) {
                    productDataStore.add(new Product(sqlInitalizer.all().get(i).name, Float.parseFloat(sqlInitalizer.all().get(i).defaultPrice), sqlInitalizer.all().get(i).currencystring, sqlInitalizer.all().get(i).description, famousPeople, ritkit));
                }

                if (sqlInitalizer.all().get(i).category.equals("Makeup")) {
                    productDataStore.add(new Product(sqlInitalizer.all().get(i).name, Float.parseFloat(sqlInitalizer.all().get(i).defaultPrice), sqlInitalizer.all().get(i).currencystring, sqlInitalizer.all().get(i).description, makeup, ritkit));
                }
                if (sqlInitalizer.all().get(i).category.equals("Calligraphic")) {
                    productDataStore.add(new Product(sqlInitalizer.all().get(i).name, Float.parseFloat(sqlInitalizer.all().get(i).defaultPrice), sqlInitalizer.all().get(i).currencystring, sqlInitalizer.all().get(i).description, calligraphic, ritkit));
                }

                if (sqlInitalizer.all().get(i).category.equals("Realistic")) {
                    productDataStore.add(new Product(sqlInitalizer.all().get(i).name, Float.parseFloat(sqlInitalizer.all().get(i).defaultPrice), sqlInitalizer.all().get(i).currencystring, sqlInitalizer.all().get(i).description, realistic, ritkit));
                }

                if (sqlInitalizer.all().get(i).category.equals("For trve lovers")) {
                    productDataStore.add(new Product(sqlInitalizer.all().get(i).name, Float.parseFloat(sqlInitalizer.all().get(i).defaultPrice), sqlInitalizer.all().get(i).currencystring, sqlInitalizer.all().get(i).description, couple, ritkit));
                }
            }


        }


    }
}
