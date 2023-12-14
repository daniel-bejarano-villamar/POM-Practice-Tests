package com.globant.web.tests;

import com.globant.web.pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginTest {
    public static final String DRIVER_PATH = "C:/Users/daniel.bejarano/Documents/IdeaProjects/POM-Practice/src/test/java/com/globant/web/utils/chromedriver.exe";
    static {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
    }

    WebDriver driver = new ChromeDriver();
    LoginPage loginPage;

    @BeforeClass
    public void setUp(){
        loginPage = new LoginPage(driver, "https://www.saucedemo.com/");
    }

    @Test
    public void testLogin(){
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLogin();

        Assert.assertEquals(loginPage.getTextToValidate(), "Products");
    }

    @AfterTest
    public void tearDown(){
//        driver.close();
    }

}