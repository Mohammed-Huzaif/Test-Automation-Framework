package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Child class will always be final
public final class LoginPage extends BrowserUtility {

    private static final By EMAIL_TEXT_BOX_LOCATOR = By.id("email");
    private static final By PASSWORD_TEXT_BOX_LOCATOR = By.id("passwd");
    private static final By SUBMIT_BUTTON_LOCATOR = By.id("SubmitLogin");
    private static final By ERROR_MESSAGE_LOCATOR = By.xpath("//div[contains(@class,'alert-danger')]//ol//li");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public MyAccountPage doLoginWith(String emailaddress, String password){
        enterText(EMAIL_TEXT_BOX_LOCATOR,emailaddress);
        enterText(PASSWORD_TEXT_BOX_LOCATOR,password);
        clickOn(SUBMIT_BUTTON_LOCATOR);
        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        return myAccountPage;
    }

    public LoginPage doLoginWithInValidCredentials(String emailaddress, String password){
        enterText(EMAIL_TEXT_BOX_LOCATOR,emailaddress);
        enterText(PASSWORD_TEXT_BOX_LOCATOR,password);
        clickOn(SUBMIT_BUTTON_LOCATOR);
        LoginPage loginPage = new LoginPage(getDriver());
        return loginPage;
    }

    public String getErrormessage(){
       return getVisibleText(ERROR_MESSAGE_LOCATOR);
    }

}
