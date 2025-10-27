package com.utility;

import com.constants.Browser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//Parent class is always be abstract
public abstract class BrowserUtility {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private WebDriverWait wait;

    public WebDriver getDriver() {

        return driver.get();
    }

    public BrowserUtility(WebDriver driver) {
        super();
        this.driver.set(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }



    public BrowserUtility(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            driver.set(new ChromeDriver());
            wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver.set(new EdgeDriver());
            wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
        } else {
            System.err.println("Invalid Browser Name.. Please select Chrome or Edge");
        }
    }

    public BrowserUtility(Browser browserName) {
        if (browserName == Browser.CHROME) {
            driver.set(new ChromeDriver());
            wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
        } else if (browserName == Browser.EDGE) {
            driver.set(new EdgeDriver());
            wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
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
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
            }
            else {
                driver.set(new ChromeDriver());
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
            }
        } else if (browserName == Browser.EDGE) {
            if(isHeadless) {
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--headless=new"); //headless
                options.addArguments("--window-size=1920,1080");
                driver.set(new EdgeDriver(options));
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
            }else {
                driver.set(new EdgeDriver());
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
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
       // WebElement element = driver.get().findElement(locator);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public void clickOn(WebElement element) {
        element.click();
    }

    public void enterText(By locator, String textToEnter) {
        //WebElement element = driver.get().findElement(locator);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.sendKeys(textToEnter);
    }

    public void clearText(By textBoxLocator) {
        //WebElement element = driver.get().findElement(textBoxLocator);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(textBoxLocator));
        element.clear();
    }

    public void selectFromDropdown(By dropdownLocator, String optionToSelect ){
        //WebElement element = driver.get().findElement(dropdownLocator);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownLocator));
        Select select = new Select(element);
        select.selectByVisibleText(optionToSelect);
    }

    public void enterSpecialKey(By locator, Keys keyToEnter) {
        //WebElement element = driver.get().findElement(locator);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.sendKeys(keyToEnter);
    }

    public List<String> getAllVisibleText(By locator) {
        List<WebElement> elementsList = driver.get().findElements(locator);
        List<String> visibleTextList = new ArrayList<String>();
        for(WebElement element : elementsList){
          visibleTextList.add(getVisibleText(element));
        }
        return visibleTextList;
    }

    public List<WebElement> getAllElements(By locator) {
        List<WebElement> elementsList = driver.get().findElements(locator);
        return elementsList;
    }

    public String getVisibleText(By locator) {
        WebElement element = driver.get().findElement(locator);
        return element.getText();
    }

    public String getVisibleText(WebElement element) {
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
