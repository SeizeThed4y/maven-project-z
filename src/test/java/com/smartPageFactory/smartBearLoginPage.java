package com.smartPageFactory;


import com.utilities.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class smartBearLoginPage extends TestBase {




    @FindBy(id = "ctl00_MainContent_username")
    WebElement userNameinputElement;

    @FindBy(id = "ctl00_MainContent_password")
    WebElement passWordInputElement;

    @FindBy(id = "ctl00_MainContent_login_button")
    WebElement loginButtonElement;


   protected static String expectedTitle = "Web Orders Login";


    public smartBearLoginPage(WebDriver driver) {

        this.driver = driver;


        PageFactory.initElements(driver, this);

    }

    public void setUserName(String userNameInput) {

        userNameinputElement.sendKeys(userNameInput);
    }

    public void setpassWord(String passWordInput) {
        passWordInputElement.sendKeys(passWordInput);
    }

    public void clickLogin() {

        loginButtonElement.click();
    }




    public void loginMethod(String userNameInput, String passWordInput) {


        this.setUserName(userNameInput);
        this.setpassWord(passWordInput);
        this.clickLogin();

    }


}
