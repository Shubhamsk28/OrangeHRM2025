package com.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElement username;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement password;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement loginBTN;

    public void setuserName(String user) {
        username.sendKeys(user);
    }

    public void setPassword(String psw){
        password.sendKeys(psw);
    }

    public  void clickloginBTN(){
        loginBTN.click();
    }
}
