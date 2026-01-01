package com.qa.testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {

    public WebDriver driver;
    public Logger logger;
    public Properties p;

    @BeforeClass
    @Parameters({"os","browser"})
    public void setup(String os, String br) throws IOException {

        //Loading config.properties file
        FileReader file=new FileReader("./src//main//resources//Config.properties");  // D:\SeleniumProject\OrangeHRM2025\src\main\resources\Config.properties
        p=new Properties();
        p.load(file);

        logger= LogManager.getLogger(this.getClass());

        if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            if (os.equalsIgnoreCase("windows")) {
                capabilities.setPlatform(Platform.WIN11);
            } else if (os.equalsIgnoreCase("mac")) {
                capabilities.setPlatform(Platform.WIN11);
            } else {
                System.out.println("No Machining OS");
            }

            switch (br.toLowerCase()) {
                case "chrome":
                    capabilities.setBrowserName("chrome");
                    ;
                    break;
                case "edge":
                    capabilities.setBrowserName("MicrosoftEdge");
                    ;
                    break;
                case "firefox":
                    capabilities.setBrowserName("firefox");
                    break;
                default:
                    System.out.println("Invalid browser name : ");
                    return;
            }
            driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
        }

        if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
            switch (br.toLowerCase()) {
                case "chrome": driver=new ChromeDriver();
                    break;
                case "edge": driver=new EdgeDriver();
                    break;
                case "firefox": driver=new FirefoxDriver();
                    break;
                default:
                    System.out.println("Invalid browser name : ");
                    return;
            }

        }
//        driver=new ChromeDriver();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            driver.get(p.getProperty("appURL"));
            driver.manage().window().maximize();

    }

    @AfterClass
    void tearDown(){
        driver.close();
    }
}
