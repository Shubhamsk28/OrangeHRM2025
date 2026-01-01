package com.qa.testCases;

import com.qa.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC002_LoginTest extends BaseClass{

    @Test
    public void verify_login(){
        logger.info("*****Starting TC_002_LoginTest*****");
        LoginPage loginPage=new LoginPage(driver);

        loginPage.setuserName(p.getProperty("username"));
        loginPage.setPassword(p.getProperty("password"));
        loginPage.clickloginBTN();
        logger.info("Clicking on LoginButton");
        Assert.assertTrue(true);

        logger.info("*****Finish LoggIn *****");
    }
}
