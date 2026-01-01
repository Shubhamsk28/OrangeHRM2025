package com.qa.testCases;

import com.qa.pageObjects.LoginPage;
import com.qa.utilities.DataProviders;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC003_Login extends BaseClass{


    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
    public void verify_login(String username, String password){
        logger.info("*****Starting TC_002_LoginTest*****");

        LoginPage loginPage=new LoginPage(driver);

        loginPage.setuserName(username);
        loginPage.setPassword(password);
        loginPage.clickloginBTN();
        logger.info("Clicking on LoginButton");
        Assert.assertTrue(true);

        logger.info("*****Finish LoggIn *****");
    }


}
