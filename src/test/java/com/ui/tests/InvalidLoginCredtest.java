package com.ui.tests;

import com.ui.pojo.User;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Listeners({com.ui.listeners.TestListener.class})
public class InvalidLoginCredtest extends TestBase {
    public static final String INVALID_EMAIL_ADDRESS = "abc@gmail.com";
    public static final String INVALID_PASSWORD = "qwert@123";

    @Test(description = "Verifies with the valid user is able to login into application",
            groups = {"e2e", "sanity"}
            )
    public void loginTest() {
        assertEquals(
                homePage.goToLoginPage().doLoginWithInValidCredentials(INVALID_EMAIL_ADDRESS,INVALID_PASSWORD)
                        .getErrormessage(),"Authentication failed.");
    }




}
