package com.cineplex.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverUtilities {

    //Private Static Instance
    private static DriverUtilities driverUtilities;
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    //Private Constructor
    private DriverUtilities() {
        // Initialize the WebDriver instance
        super();
    }

    //Public static getInstance()
    public static DriverUtilities getInstance() {
        if (driverUtilities == null) {
            driverUtilities = new DriverUtilities();
        }
        return driverUtilities;
    }

    public WebDriver getDriver() {
        if (driver.get() == null) {
            driver.set(new ChromeDriver());
        }
        return driver.get();
    }

    public void createDriver() {
        String driverName = getDriverName();

        switch (driverName.toLowerCase()) {
            case "chrome":
                driver.set(new ChromeDriver());
                break;
            case "firefox":
                driver.set(new FirefoxDriver());
                break;
            case "edge":
                driver.set(new EdgeDriver());
                break;
            default:
                break;
        }
    }

    private String getDriverName() {
        String browser = com.cineplex.utils.BrowserContext.getBrowser();

        if(browser != null){
            return browser;
        }else{
            return "chrome";
        } 
    }

    //Quit Driver
    public void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

}
