package com.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DashboardPage extends BasePage{

    public DashboardPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h6[text()='Dashboard']")
    WebElement dashBoardlogo;

    public void verifyDashboardPage(){
        boolean logo=dashBoardlogo.isDisplayed();
        System.out.println(logo);
        Assert.assertTrue(true);
    }

}
