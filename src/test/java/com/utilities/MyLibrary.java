package com.utilities;

import com.github.javafaker.Faker;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MyLibrary {

    final static Logger logger = Logger.getLogger(MyLibrary.class);
    public WebDriver driver;
    public Faker faker;
    public Select select;
    Random random;
    public WebElement productOption;
    public static boolean isDemoMode = true;
    public Email email;

    public MyLibrary(WebDriver driver) {
        this.driver = driver;
    }


    public String getTitle() {

        return driver.getTitle();
    }

    public void openURL(String url) {

        driver.get(url);
    }


    public String randomFirstName() {

        faker = new Faker();

        return faker.name().firstName();
    }

    public String randomLastName() {
        faker = new Faker();

        return faker.name().lastName();
    }

    public String randomFullName() {
        faker = new Faker();

        return faker.name().fullName();
    }

    public String randomStreet() {
        faker = new Faker();

        return faker.address().streetAddress();
    }

    public String randomCity() {
        faker = new Faker();

        return faker.address().city();
    }

    public String randomState() {
        faker = new Faker();

        return faker.address().state();
    }


    public String randomZip() {
        faker = new Faker();

        return faker.address().zipCode().substring(0, 5);
    }

    public String randomCardNumber() {
        faker = new Faker();

        return faker.finance().creditCard().replaceAll("-", "");
    }

    public String randomNumber() {

        faker = new Faker();

        return faker.number().digit();

    }

    public void enterFullName(WebElement by) {

        by.sendKeys(randomFullName());
    }

    public void enterFirstName(WebElement by) {
        by.sendKeys(randomFirstName());
    }

    public void enterLastName(WebElement by) {
        by.sendKeys(randomLastName());
    }

    public void enterStreet(WebElement by) {

        by.sendKeys(randomStreet());
    }


    public void enterCity(WebElement by) {
        by.sendKeys(randomCity());
    }


    public void enterState(WebElement by) {
        by.sendKeys(randomState());
    }

    public void enterZip(WebElement by) {
        by.sendKeys(randomZip());
    }

    public void enterCreditCardNumber(WebElement by) {
        by.sendKeys(randomCardNumber());
    }

    public void enterExpDate(WebElement by) {
        by.sendKeys("11/20");
    }

    public void enterQuantity(WebElement by) {
        by.sendKeys(randomNumber());
    }


    public void clickMethod(WebElement by) {
        by.click();
    }


    public void randomEmail(WebElement by) {
        by.sendKeys(randomFirstName() + randomLastName() + "@gmail.com");
    }

    public void selectDropdownByIndex(By by, int index) {


        try {
            Select dropdown = new Select(driver.findElement(by));

            dropdown.selectByIndex(index);
        } catch (Exception e) {

            logger.error("Error: " + e);
        }


    }


    public void highLightElementMethod(By by) {

        WebElement element = null;

        try {
            if (isDemoMode) {
                for (int i = 0; i <= 2; i++) {
                    element = driver.findElement(by);
                    //Create object of a JavascriptExecutor interface
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    //use executeScript() method and pass the arguments
                    //Here i pass values based on css style. Yellow background color with solid red color border.
                    js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

                    wait(0.2);


                    element = driver.findElement(by);
                    //Create object of a JavascriptExecutor interface
                    js = (JavascriptExecutor) driver;
                    //use executeScript() method and pass the arguments
                    //Here i pass values based on css style. Yellow background color with solid red color border.
                    js.executeScript("arguments[0].setAttribute('style', 'background: red; border: 2px solid yellow;');", element);


                    wait(0.2);


                    element = driver.findElement(by);
                    //Create object of a JavascriptExecutor interface
                    js = (JavascriptExecutor) driver;
                    //use executeScript() method and pass the arguments
                    //Here i pass values based on css style. Yellow background color with solid red color border.
                    js.executeScript("arguments[0].setAttribute('style', 'background: blue; border: 2px solid red;');", element);

                    wait(0.2);
                }
            }
        } catch (Exception e) {
            logger.error("Error" + e);
        }

    }

    public void wait(double second) {
        try {
            Thread.sleep((int) (second * 1000));
        } catch (Exception e) {
            logger.error("Error" + e);
        }

    }

    public void highLightElementMethod(WebElement element) {

        try {
            if (isDemoMode) {
                for (int i = 0; i <= 2; i++) {

                    //Create object of a JavascriptExecutor interface
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    //use executeScript() method and pass the arguments
                    //Here i pass values based on css style. Yellow background color with solid red color border.
                    js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

                    wait(0.2);


                    //Create object of a JavascriptExecutor interface
                    js = (JavascriptExecutor) driver;
                    //use executeScript() method and pass the arguments
                    //Here i pass values based on css style. Yellow background color with solid red color border.
                    js.executeScript("arguments[0].setAttribute('style', 'background: red; border: 2px solid yellow;');", element);


                    wait(0.2);


                    //Create object of a JavascriptExecutor interface
                    js = (JavascriptExecutor) driver;
                    //use executeScript() method and pass the arguments
                    //Here i pass values based on css style. Yellow background color with solid red color border.
                    js.executeScript("arguments[0].setAttribute('style', 'background: white; border: 2px solid red;');", element);
                }
            }
        } catch (Exception e) {
            logger.error("Error" + e);
        }

    }


    public void randomDropBox(WebElement by) {
        select = new Select(by);
        random = new Random();
        List<WebElement> list = select.getOptions();
        int siteCount = list.size();
        int siteSelect = random.nextInt(siteCount);
        select.selectByIndex(siteSelect);

    }


    public void randomRadioButton(List<WebElement> by) {
        List<WebElement> radios = by;
        radios.get(random.nextInt(radios.size())).click();

    }

    public boolean elementDisplayed(By by) {

        try {
            return driver.findElement(by).isDisplayed();

        } catch (NoSuchElementException e) {
            return false;
        }

    }

    public boolean elementDisplayedS(By by) {
        return driver.findElements(by).isEmpty();
    }


    public void getTheRowText(List<WebElement> by) {
        List<WebElement> listOrder = by;
        List list = new ArrayList();
        for (int i = 0; i < listOrder.size(); i++) {
            list.add(listOrder.get(i).getText());
            System.out.println(list.toString());

        }
    }


    public void sendEmail(String senderEmail, String senderPassword, String subject, String text, String receiver, String receiver2) throws EmailException {


        email = new SimpleEmail();
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(965);
        email.setAuthenticator(new DefaultAuthenticator(senderEmail, senderPassword));  //for authentication
        email.setSSLOnConnect(true);    // has to be true in order to send
        email.setFrom(senderEmail);   // sender' email address
        email.setSubject(subject);   // object of the email
        email.setMsg(text);  // text body part
        email.addTo(receiver); //recevier email
        email.addTo(receiver2); //recevier email
        email.send();
        System.out.println("Send Successfully");


    }

}

