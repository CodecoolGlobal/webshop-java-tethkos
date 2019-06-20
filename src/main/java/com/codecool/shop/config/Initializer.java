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
        Supplier allSupplier = new Supplier("All Artists","All");
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
        productCategoryDataStore.add(calligraphic);
        ProductCategory couple = new ProductCategory("For trve lovers", "Tattoo", "");
        productCategoryDataStore.add(couple);



        //setting up products and printing it

        productDataStore.add(new Product("Mr. Jackson", 5990, "HUF", "Get the King of Pop on you're body", famousPeople, pony));
        productDataStore.add(new Product("Jordan", 2990, "HUF", "I you likes basketball get one", makeup, bang));
        productDataStore.add(new Product("Regret", 1990, "HUF", "YOLO", calligraphic, johnny));
        productDataStore.add(new Product("Love", 3990, "HUF", "for troubled personalities", calligraphic, ritkit));
        productDataStore.add(new Product("Megan", 4990, "HUF", "For after breakups", calligraphic, ritkit));
        productDataStore.add(new Product("Onion", 1990, "HUF", "For layered ones", calligraphic, bang));
        productDataStore.add(new Product("MC Donald", 1990, "HUF", "For that one meal to remember", calligraphic, pony));
        productDataStore.add(new Product("Live You're Life", 1990, "HUF", "YOLO 2", calligraphic, ritkit));
        productDataStore.add(new Product("It's is your life", 1990, "HUF", "Get the famous song on your belly", calligraphic, ritkit));
        productDataStore.add(new Product("Marilyn", 8990, "HUF", "What else to say", realistic, pony));
        productDataStore.add(new Product("Toilet", 3990, "HUF", "You're favorite spot on the world", realistic, pony));
        productDataStore.add(new Product("Twilight", 9990, "HUF", "Mr. Vampire himself on ouy", realistic, bang));
        productDataStore.add(new Product("Family Portrait", 19990, "HUF", "First is Family", realistic, johnny));
        productDataStore.add(new Product("Drake", 3590, "HUF", "For true fans", calligraphic, johnny));
        productDataStore.add(new Product("Spiderman", 5430, "HUF", "With great tatoo comes great responsibility", realistic, bang));
        productDataStore.add(new Product("Ninja turtle", 6600, "HUF", "Not only for teenagers", makeup, pony));
        productDataStore.add(new Product("Great heart", 10000, "HUF", "Perfect engagement gift", couple,johnny));
        productDataStore.add(new Product("WallMarkt", 6690, "HUF", "10% OFF", calligraphic,johnny));
        productDataStore.add(new Product("South Park", 15440, "HUF", "You killed Kenny", calligraphic,johnny));
        productDataStore.add(new Product("Monster", 3450, "HUF", "Show the ebast inside you", calligraphic,ritkit));
        productDataStore.add(new Product("Smile", 6660, "HUF", "You can never be pretty enough", makeup,ritkit));
        productDataStore.add(new Product("Russian standard", 6660, "HUF", "You can catch Igor with your look", makeup,pony));
        productDataStore.add(new Product("Disco Queen", 9990, "HUF", "For the real gold diggers #partyneverstops", makeup,pony));
        productDataStore.add(new Product("Natural look", 3490, "HUF", "For animal lovers", makeup,pony));
        productDataStore.add(new Product("EKIN", 3490, "HUF", "Just do it!", makeup,bang));
        productDataStore.add(new Product("Babyboi", 5690, "HUF", "Welcome to the family", makeup,bang));
        productDataStore.add(new Product("Twins", 5690, "HUF", "One is never enough", makeup,bang));
        productDataStore.add(new Product("Babygurl", 5690, "HUF", "Little princess", makeup,johnny));
        productDataStore.add(new Product("Pink Foyld", 5690, "HUF", "Dark side of the art", makeup,johnny));
        productDataStore.add(new Product("Mrs. Jolie", 5690, "HUF", "Tomb Raider on your skin", makeup,ritkit));
        productDataStore.add(new Product("Hell of a Spite", 5690, "HUF", "F**k Coke", makeup,ritkit));


    }
}
