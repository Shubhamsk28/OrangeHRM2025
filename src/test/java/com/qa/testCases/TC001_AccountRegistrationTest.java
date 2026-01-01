package com.qa.testCases;

import com.qa.pageObjects.DashboardPage;
import com.qa.pageObjects.LoginPage;

import org.testng.Assert;

import org.testng.annotations.Test;


public class TC001_AccountRegistrationTest extends BaseClass  {
    @Test(priority = 1)
    public void Login(){
        try {
            logger.info("***** Starting LoggIn *****");
            LoginPage loginPage=new LoginPage(driver);

            loginPage.setuserName(p.getProperty("username"));
            loginPage.setPassword(p.getProperty("password"));
            loginPage.clickloginBTN();
            logger.info("Clicking on LoginButton");
            Assert.assertTrue(true);

            logger.info("*****Finish LoggIn *****");
        }catch (Exception e){
            logger.error("Test failed");
//            logger.debug("Debug logs");
            Assert.fail();
        }

    }

    @Test(priority = 2)
    public void verifyDashBoard() throws InterruptedException {
        try {
            logger.info("** Start Verify Dashboard **");
            Thread.sleep(3000);
            logger.info("** Validate Dashboard page **");
            DashboardPage dashboardPage=new DashboardPage(driver);
            dashboardPage.verifyDashboardPage();
            logger.info("** Finish Verify Dashboard **");
        }catch (Exception e){
            logger.error("Test failed");
//            logger.debug("Debug logs");
            Assert.fail();
        }

    }


}
