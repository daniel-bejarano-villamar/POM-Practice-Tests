package com.globant.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage {

    WebDriver driver;

    public CheckoutOverviewPage(WebDriver driver, String url){
        this.driver = driver;
        this.driver.get(url);
        PageFactory.initElements(driver, this);
    }

    //Mapear los elementos

    @FindBy(id="finish")
    private WebElement finishButton;

    @FindBy(className = "title")
    private WebElement validateText;

    //

    public void clickOnFinish(){
        finishButton.click();
    }

    public String getTextToValidate(){
        return validateText.getText();
    }
}