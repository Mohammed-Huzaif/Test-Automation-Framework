package com.ui.pages;

import com.constants.Browser;
import com.constants.Env;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.PropertiesUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;

import static com.constants.Env.QA;

//Child class will always be final
public final class HomePage extends BrowserUtility {
    private static final By SIGN_IN_LOCATOR = By.xpath("//a[contains(text(),\"Sign\")]");

    public HomePage(Browser browserName, boolean isHeadless) throws FileNotFoundException {
        super(browserName, isHeadless);
        goToWebsite(JSONUtility.readJSON(QA).getUrl());
        maximizeWindow();
    }

    public HomePage(WebDriver driver) {
        super(driver);
        goToWebsite(JSONUtility.readJSON(QA).getUrl());
        maximizeWindow();
    }

    public LoginPage goToLoginPage() {
        clickOn(SIGN_IN_LOCATOR);
        return new LoginPage(getDriver());
    }


}
