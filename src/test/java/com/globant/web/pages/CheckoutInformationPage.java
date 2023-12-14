package com.globant.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutInformationPage {

    WebDriver driver;

    public CheckoutInformationPage(WebDriver driver, String url){
        this.driver = driver;
        this.driver.get(url);
        PageFactory.initElements(driver, this);
    }

    //Mapear los elementos
    @FindBy(id="first-name")
    private WebElement firstName;

    @FindBy(id="last-name")
    private WebElement lastName;

    @FindBy(id="postal-code")
    private WebElement postalCode;

    @FindBy(id="continue")
    private WebElement continueButton;

    @FindBy(className = "title")
    private WebElement validateText;

    //

    public void enterFirstName(String first_ame){
        firstName.sendKeys(first_ame);
    }

    public void enterLastName(String last_Name){
        lastName.sendKeys(last_Name);
    }

    public void enterPostalCode(String postal_code){
        postalCode.sendKeys(postal_code);
    }

    public void clickOnContinue(){
        continueButton.click();
    }

    public String getTextToValidate(){
        return validateText.getText();
    }
}
