package com.globant.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver, String url){
        this.driver = driver;
        this.driver.get(url);
        PageFactory.initElements(driver, this);
    }

    //Mapear los elementos
    @FindBy(id="checkout")
    private WebElement checkoutButton;

    @FindBy(className = "title")
    private WebElement validateText;

    //

    public String getTextToValidate(){
        return validateText.getText();
    }

    public void clickOnCheckout(){
        checkoutButton.click();
    }
}
