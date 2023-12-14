package com.globant.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver, String url){
        this.driver = driver;
        this.driver.get(url);
        PageFactory.initElements(driver, this);
    }

    //Mapear los elementos
    @FindBy(id="user-name")
    private WebElement userName;

    @FindBy(id="password")
    private WebElement password;

    @FindBy(id="login-button")
    private WebElement loginButton;

    @FindBy(className = "title") //Should go to ProductPages
    private WebElement validateText;

    //

    public void enterUsername(String user){
        userName.sendKeys(user);
    }

    public void enterPassword(String psw){
        password.sendKeys(psw);
    }

    public void clickOnLogin(){
        loginButton.click();
    }

    public String getTextToValidate(){
        return validateText.getText();
    }
}
