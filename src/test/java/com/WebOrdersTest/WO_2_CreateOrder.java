package com.WebOrdersTest;

import com.smartPageFactory.smartBearHomePage;
import com.smartPageFactory.smartBearLoginPage;
import com.utilities.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class WO_2_CreateOrder extends TestBase {

    smartBearHomePage bearHomePage;
    smartBearLoginPage bearLoginPage;
    Random random;
    Select select;


    @FindBy(xpath = "//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']")
    WebElement productOptions;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']")
    WebElement quantity;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_txtName']")
    WebElement customerName;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_TextBox2']")
    WebElement streetName;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_TextBox3']")
    WebElement cityName;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_TextBox4']")
    WebElement stateName;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_TextBox5']")
    WebElement zipCode;

    @FindBy(xpath = "//table[@id='ctl00_MainContent_fmwOrder_cardList']")
    List<WebElement> radioButtons;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_TextBox6']")
    WebElement cardNumber;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_TextBox1']")
    WebElement expireDate;

    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    WebElement processButton;

    @FindBy(xpath = "//tbody/tr[2]")
    List <WebElement> myOrder;


    public void Create_Order_Test() {

        bearLoginPage = new smartBearLoginPage(driver);
        bearHomePage = new smartBearHomePage(driver);
        random = new Random();

        myLibrary.openURL("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        bearLoginPage.loginMethod("Tester", "test");

        bearHomePage.OrderClickMethod();


        myLibrary.randomDropBox(productOptions);

        myLibrary.enterQuantity(quantity);

        myLibrary.enterFullName(customerName);


        myLibrary.enterStreet(streetName);


        myLibrary.enterCity(cityName);


        myLibrary.enterState(stateName);


        myLibrary.enterZip(zipCode);

        myLibrary.randomRadioButton(radioButtons);


        myLibrary.enterCreditCardNumber(cardNumber);


        myLibrary.enterExpDate(expireDate);


        myLibrary.clickMethod(processButton);

        bearHomePage.viewAllOrdersClickMetHod();

        myLibrary.getTheRowText(myOrder);



    }

}
