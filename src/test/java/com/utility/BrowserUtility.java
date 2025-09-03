package com.utility;

import com.constants.Browser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

//Parent class is always be abstract
public abstract class BrowserUtility {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public WebDriver getDriver() {

        return driver.get();
    }

    public BrowserUtility(WebDriver driver) {
        super();
        this.driver.set(driver);
    }

    public BrowserUtility(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            driver.set(new ChromeDriver());
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver.set(new EdgeDriver());
        } else {
            System.err.println("Invalid Browser Name.. Please select Chrome or Edge");
        }
    }

    public BrowserUtility(Browser browserName) {
        if (browserName == Browser.CHROME) {
            driver.set(new ChromeDriver());
        } else if (browserName == Browser.EDGE) {
            driver.set(new EdgeDriver());
        } else {
            System.err.println("Invalid Browser Name.. Please select Chrome or Edge");
        }
    }

    public BrowserUtility(Browser browserName, boolean isHeadless) {
        if (browserName == Browser.CHROME) {
            if(isHeadless) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless=new"); //headless
                options.addArguments("--window-size=1920,1080");
                driver.set(new ChromeDriver(options));
            }
            else {
                driver.set(new ChromeDriver());
            }
        } else if (browserName == Browser.EDGE) {
            if(isHeadless) {
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--headless=new"); //headless
                options.addArguments("--window-size=1920,1080");
                driver.set(new EdgeDriver(options));
            }else {
                driver.set(new EdgeDriver());
            }
        } else {
            System.err.println("Invalid Browser Name.. Please select Chrome or Edge");
        }
    }


    public void goToWebsite(String url) {
        driver.get().get(url);
    }

    public void maximizeWindow() {
        driver.get().manage().window().maximize();
    }

    public void clickOn(By locator) {
        WebElement element = driver.get().findElement(locator);
        element.click();
    }

    public void enterText(By locator, String textToEnter) {
        WebElement element = driver.get().findElement(locator);
        element.sendKeys(textToEnter);
    }

    public String getVisibleText(By locator) {
        WebElement element = driver.get().findElement(locator);
        return element.getText();
    }

    public String takeScreenshot(String name) {
        TakesScreenshot screenshot = (TakesScreenshot) driver.get();
        Date date = new Date();
        File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
        SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
        String timeStamp = format.format(date);
        String path = "./screenshots/" + name + "-" + timeStamp + ".png";
        System.out.println(path);
        File screenshotFile = new File(path);
        try {
            FileUtils.copyFile(screenshotData, new File(screenshotFile.getAbsolutePath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return path;


    }

    public void quit() {
        if(getDriver() !=null){
            getDriver().quit();
        }
    }
}
