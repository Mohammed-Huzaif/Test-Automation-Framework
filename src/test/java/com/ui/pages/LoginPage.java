package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Child class will always be final
public final class LoginPage extends BrowserUtility {

    private static final By EMAIL_TEXT_BOX_LOCATOR = By.id("email");
    private final By PASSWORD_TEXT_BOX_LOCATOR = By.id("passwd");
    private final By SUBMIT_BUTTON_LOCATOR = By.id("SubmitLogin");


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
}
