package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BrowserUtility {

    private static final By PAYMENT_BY_WIRE_LOCATOR  = By.xpath("//a[@title=\"Pay by bank wire\"]");
    private static final By CONFIRM_PAYMENT_BUTTON_LOCATOR = By.xpath("//p//button[@type=\"submit\"]");
    private static final By ALERT_SUCCESS_MESSAGE_LOCATOR = By.xpath("//p[@class=\"alert alert-success\"]");

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public String makePaymentByWire(){
        clickOn(PAYMENT_BY_WIRE_LOCATOR);
        clickOn(CONFIRM_PAYMENT_BUTTON_LOCATOR);
       return getVisibleText(ALERT_SUCCESS_MESSAGE_LOCATOR);
    }

}
