package com.globant.web.tests;

import com.globant.web.pages.*;


import com.globant.web.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class PurchaseTest {
    public static final String DRIVER_PATH = "C:/Users/daniel.bejarano/Documents/IdeaProjects/POM-Practice/src/test/java/com/globant/web/utils/chromedriver.exe";
    static {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
    }

    WebDriver driver = new ChromeDriver();
    LoginPage loginPage;
    ProductsPage productsPage;

    CartPage cartPage;

    CheckoutInformationPage checkoutInformationPage;

    CheckoutOverviewPage checkoutOverviewPage;


    @BeforeClass
    public void setUp(){
        loginPage = new LoginPage(driver, "https://www.saucedemo.com/");
    }
    public void purchase(){productsPage = new ProductsPage(driver, "https://www.saucedemo.com/inventory.html");}
    public void checkout(){cartPage = new CartPage(driver, "https://www.saucedemo.com/cart.html");}

    public void checkoutOverview(){checkoutOverviewPage = new CheckoutOverviewPage(driver, "https://www.saucedemo.com/cart.html");}

    public void checkoutInformation(){checkoutInformationPage = new CheckoutInformationPage(driver, "https://www.saucedemo.com/checkout-step-one.html");}

    @BeforeTest
    public void login(){
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLogin();
        Assert.assertEquals(loginPage.getTextToValidate(), "Products");
    }

    @Test
    public void purchaseTest(){
        productsPage.clickOnBackpackButton();
        productsPage.clickOnShoppingCart();
        Assert.assertEquals(productsPage.getTextToValidate(), "Your Cart");

        cartPage.clickOnCheckout();
        Assert.assertEquals(cartPage.getTextToValidate(), "Checkout: Your Information");


        checkoutInformationPage.enterFirstName("Daniel");
        checkoutInformationPage.enterLastName("Bejarano");
        checkoutInformationPage.enterPostalCode("090509");
        checkoutInformationPage.clickOnContinue();
        Assert.assertEquals(checkoutInformationPage.getTextToValidate(), "Checkout: Overview");


        checkoutOverviewPage.clickOnFinish();
        Assert.assertEquals(checkoutOverviewPage.getTextToValidate(), "Checkout: Complete!");
    }


    @AfterTest
    public void tearDown(){
//        driver.close();
    }

}