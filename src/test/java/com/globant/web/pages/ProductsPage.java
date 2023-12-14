package com.globant.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class ProductsPage {
    WebDriver driver;

    public ProductsPage(WebDriver driver, String url){
        this.driver = driver;
        this.driver.get(url);
        PageFactory.initElements(driver, this);
    }

    //Mapear los elementos
    @FindBy(id="add-to-cart-sauce-labs-backpack")
    private WebElement backpackButton;

    @FindBy(id="add-to-cart-sauce-labs-bike-light")
    private WebElement bikeLightButton;

    @FindBy(id="add-to-cart-sauce-labs-bolt-t-shirt")
    private WebElement tShirtButton;

    @FindBy(className = "shopping_cart_badge")
    private WebElement shopping_cartButton;

    @FindBy(className = "title")
    private WebElement validateText;

    //

    public void clickOnBackpackButton(){
        backpackButton.click();
    }

    public void clickOnBikeLightButton(){
        bikeLightButton.click();
    }

    public void clickOnTShirtButton(){
        tShirtButton.click();
    }

    public String getTextToValidate(){
        return validateText.getText();
    }

    public void clickOnShoppingCart(){
        shopping_cartButton.click();
    }


}
