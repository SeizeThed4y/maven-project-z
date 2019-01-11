package com.tests;

import com.WebOrdersTest.WO_1_Product;
import com.WebOrdersTest.WO_2_CreateOrder;
import com.utilities.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


public class smartBearSoftwareTest extends TestBase {




    @Test(priority = 0)
    public void WO_1_Product() {
        WO_1_Product wo_1 = PageFactory.initElements(driver, WO_1_Product.class);
        wo_1.Products_Test();
    }

    @Test(priority = 1)
    public void WO_2_Create_Order(){

        WO_2_CreateOrder wo_2_createOrder = PageFactory.initElements(driver,WO_2_CreateOrder.class);
        wo_2_createOrder.Create_Order_Test();

    }




}
