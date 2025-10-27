package com.ui.tests;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.FileNotFoundException;

import static com.constants.Browser.CHROME;

public class TestBase {
    protected HomePage homePage;
    Logger logger = LoggerUtility.getLogger(this.getClass());
    private boolean isLambdaTest;


    @Parameters({"browser", "isLambdaTest", "isHeadless"})
    @BeforeMethod(description = "Load the Homepage of the website")
    public void setUp(
            @Optional("chrome") String browser,
            @Optional("false") boolean isLambdaTest,
            @Optional("false") boolean isHeadless,
            ITestResult result) throws FileNotFoundException {
        WebDriver lambdaDriver;
        if (isLambdaTest) {
            lambdaDriver = LambdaTestUtility.initializeLambdatestSession(browser, result.getMethod().getMethodName());
            homePage = new HomePage(lambdaDriver);
        } else {
            //Running the test on Local Machine
            logger.info("Load the Homepage of the Website");
            homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), isHeadless);
        }
    }

    public BrowserUtility getInstance() {
        return homePage;
    }

//    @AfterMethod
//    public void tearDown() {
//
//        if (isLambdaTest){
//            LambdaTestUtility.quitSession();
//        } else{
//            homePage.quit();
//        }
//
//    }
}
