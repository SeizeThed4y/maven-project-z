package com.WebOrdersTest;

import com.smartPageFactory.smartBearHomePage;
import com.smartPageFactory.smartBearLoginPage;
import com.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class WO_1_Product extends TestBase {

    smartBearLoginPage bearLoginPage;
    smartBearHomePage bearHomePage;


    public void Products_Test() {
        bearLoginPage = new smartBearLoginPage(driver);
        bearHomePage = new smartBearHomePage(driver);

        myLibrary.openURL("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        bearLoginPage.loginMethod("Tester", "test");

        List<WebElement> allOders = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[3]"));
        List allOdersList = new ArrayList();
        for (int i = 0; i < allOders.size(); i++) {
            allOdersList.add(allOders.get(i).getText());
        }
        bearHomePage.viewAllProdcutClickMethod();

        List<WebElement> allProducts = driver.findElements(By.xpath("//table[@class='ProductsTable']/tbody/tr/td[1]"));
        List allProductsList = new ArrayList();
        for (int i = 0; i < allProducts.size(); i++) {
            allProductsList.add(allProducts.get(i).getText());
        }

        for (int i = 0; i < allOdersList.size(); i++) {
            Assert.assertTrue(allOdersList.containsAll(allProductsList));
        }
    }
}
