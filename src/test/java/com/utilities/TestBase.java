package com.utilities;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
   final static Logger log = Logger.getLogger(TestBase.class);

    protected static WebDriver driver;
    protected static MyLibrary myLibrary;
    protected static SoftAssert softAssert;
    protected static Actions actions;
    protected static Faker faker;
    protected static EmailManager emailManager;

    @BeforeClass

    public void setUpDriver() {

        WebDriverManager.chromedriver().setup();
        emailManager = new EmailManager();

        log.info("****************************************************************************");
        log.info("****************************************************************************");
        log.info("****************************************************************************");
        log.info("***************************** ALL TEST STARTED *****************************");
        log.info("****************************************************************************");
        log.info("****************************************************************************");
        log.info("****************************************************************************");

    }

    @BeforeMethod

    public void setUpMethod() {


        driver = new ChromeDriver();
        actions = new Actions(driver);
        softAssert = new SoftAssert();
        myLibrary = new MyLibrary(driver);
        faker = new Faker();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);


    }


    @AfterMethod
    public void tearDownMethod()  {


        softAssert.assertAll();

        if (driver != null) {

            driver.quit();
        }

    }


    @AfterClass

    public void afterClassMethod(){
        log.info("****************************************************************************");
        log.info("****************************************************************************");
        log.info("****************************************************************************");
        log.info("************************** ALL TEST ENDED **********************************");
        log.info("****************************************************************************");
        log.info("****************************************************************************");
        log.info("****************************************************************************");

    }


}
