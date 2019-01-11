package com.smartPageFactory;

import com.utilities.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class smartBearHomePage extends TestBase {

    @FindBy(xpath = "//a[contains(text(),'View all products')]")
    WebElement viewAllProductsElement;

    @FindBy(xpath = "//a[contains(text(),'View all orders')]")
    WebElement viewallOrdersElement;

    @FindBy(xpath = "//a[contains(text(),'Order')]")
    WebElement orderClickElement;




    public smartBearHomePage(WebDriver driver) {

        this.driver = driver;


        PageFactory.initElements(driver, this);

    }


    public void viewAllProdcutClickMethod() {

        viewAllProductsElement.click();
    }


    public void viewAllOrdersClickMetHod(){

        viewallOrdersElement.click();
    }


    public void OrderClickMethod(){

        orderClickElement.click();

    }



}
