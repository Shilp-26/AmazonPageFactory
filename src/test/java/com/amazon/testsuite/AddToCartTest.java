package com.amazon.testsuite;

import com.amazon.pages.HomePage;
import com.amazon.pages.ProductPage;
import com.amazon.pages.ResultsPage;
import com.amazon.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCartTest extends TestBase {

    HomePage homePage;
    ProductPage productPage;
    ResultsPage resultsPage;


    @BeforeMethod
    public void initialize() {
        homePage = new HomePage();
        productPage = new ProductPage();
        resultsPage=new ResultsPage();
    }

    @Test
    public void addLaptopToCart() {
        homePage.searchForProduct("Laptop");
        resultsPage.isProductDisplayed("ASUS L410 MA-DB04 Ultra Thin Laptop, 14” FHD Display, Intel Celeron N4020 Processor, 4GB RAM, 128GB Storage, NumberPad, Windows 10 Home in S Mode, Star Black");
        productPage.selectQty("3");
        productPage.clickOnAddToCartBtn();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        productPage.verifyLaptopAddToCartMessage("Added to Cart");
    }

    @Test
    public void addMobilePhoneToCart() {
        homePage.searchForProduct("Mobile Phone");
        resultsPage.isProductDisplayed("Samsung Galaxy A52 5G, Factory Unlocked Smartphone, Android Cell Phone, Water Resistant, 64MP Camera, US Version, 128GB, Black");
        productPage.selectQty("2");
        productPage.clickOnAddToCartBtn();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        productPage.verifyLaptopAddToCartMessage("Added to Cart");
    }
    }

