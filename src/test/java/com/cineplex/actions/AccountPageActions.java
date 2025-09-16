/*
 * AccountPageActions.java
 * This class contains helper methods to all step definitions for Account Management Scenarios.
 * Author: Abhiroop Yerramilli
 * Date: 22 August 2025
 * Project: Cineplex Automation testing using Selenium + Cucumber
 */

package com.cineplex.actions;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * This class contains all actions for the Account Management Features.
 */
public class AccountPageActions {

    //Private variables
    private WebDriver driver;
    private WebDriverWait wait;

    //Constructor
    public AccountPageActions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /*
     * This method opens the login page, waits for the necessary elements to load, and verifies the page title.
     */
    public void openLoginPage() {
        driver.manage().window().maximize();
        driver.get("https://www.cineplex.com");

        // Handle first-time cookie pop-up safely.
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement okButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='OK']"))
            );
            okButton.click();
            } catch (Exception e) {
            // Popup not present, continue
        }

        
        //Getting the Account button dynamically and clicking it
        driver.findElement(By.xpath("//button[.//span[text()='Account']]")).click();

        //Navigation to the login interface
        WebElement loginBtn = wait.until(
            ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'LOGIN')]"))
        );
        loginBtn.click();

        //Switching driver frame to iframe to enable getting frame elements
        WebElement iframe = wait.until(
            ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[contains(@class,'modal')]//iframe")
            )
        );
        driver.switchTo().frame(iframe);

        //Wait for the iframe to load and verify its title
        new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(d -> ((JavascriptExecutor)d)
                .executeScript("return document.title;")
                .equals("Log In - Cineplex Connect")
        );

        //Get the iframe title and assert to verify current screen/status
        String iframeTitle = (String)((org.openqa.selenium.JavascriptExecutor) driver)
        .executeScript("return document.title;");
        assertEquals("Log In - Cineplex Connect", iframeTitle);

        //Switching back to default frame
        driver.switchTo().defaultContent();
        System.out.println("Login page opened and iframe verified");
    }

    /*
     * This method interacts with the email input field.
     */
    public void emailFieldAction(String email) {

        //Wait for the email field to be visible
        WebElement emailField = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']"))
        );

        //Clicking the email field and entering the email
        emailField.click();
        emailField.sendKeys(email);
    }

    /*
     * This method interacts with the password input field.
     */
    public void passwordFieldAction(String password) {

        //Wait for the password field to be visible
        WebElement passwordField = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']"))
        );

        //Clicking the password field and entering the password
        passwordField.click();
        passwordField.sendKeys(password);
    }

    /*
     * This method enters the user credentials.
     */
    public void enterCredentials(String email, String password) {

        //Switching driver frame to iframe to enable logging in
        WebElement iframe = wait.until(
            ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[contains(@class,'modal')]//iframe")
            )
        );
        driver.switchTo().frame(iframe);

        //Interacting with email and password fields
        emailFieldAction(email);
        passwordFieldAction(password);

        //Switching back to default frame
        driver.switchTo().defaultContent();

        System.out.println("Email and Password entered.");
    }

    /*
     * This method clicks the login button.
     */
    public void clickLoginButton() {

        //Switching driver frame to iframe to enable clicking login button
        WebElement iframe = wait.until(
            ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[contains(@class,'modal')]//iframe")
            )
        );
        driver.switchTo().frame(iframe);

        //Wait for the login button to be clickable
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.id("btnLogin")
        ));

        //Clicking the login button
        loginButton.click();

        //Switching back to default frame
        driver.switchTo().defaultContent();
    }

    /*
     * This method verifies the 2-Step Verification page shows up on successful login.
     */
    public void verifyTwoStepVerificationPage(){

        //Switching driver frame to iframe to enable verifying 2-Step Verification page
        WebElement iframe = wait.until(
            ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[contains(@class,'modal')]//iframe")
            )
        );
        driver.switchTo().frame(iframe);

        //Wait for the 2-Step Verification header to be visible
        WebElement twoStepHeader = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//h2[contains(text(),'Protect Your Account with 2-Step Verification')]")
                )
        );

        //Verifying the 2-Step Verification header text
        assertEquals("Protect Your Account with 2-Step Verification", twoStepHeader.getText());

        //Switching back to default frame
        driver.switchTo().defaultContent();

        System.out.println("Redirected to 2-Step Verification Setup page.");
    }

    /*
     * This method verifies the error message is displayed for invalid login attempts.
     */
    public void verifyErrorMessage() {

        //Getting the error message element
        WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//*[contains(text(),'incorrect') or contains(text(),'Invalid')]")
        ));

        //Getting the error message text and asserting it
        String errorMessage = errorMsg.getText();
        assertEquals("The username and/or password is incorrect.", errorMessage);
    }

}
