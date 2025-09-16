/*
 * GiftCardPageActions.java
 * This class contains helper methods to all step definitions for Gift Card Scenarios.
 * Author: Abhiroop Yerramilli
 * Date: 22 August 2025
 * Project: Cineplex Automation testing using Selenium + Cucumber
 */

package com.cineplex.actions;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * This class contains all actions for the Gift Card Management Features.
 */
public class GiftCardPageActions {

    // Private variables
    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public GiftCardPageActions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /*
     * This method opens the home page and handles any cookie pop-ups.
     */
    public void openHomePage() {

        //Maximizing the browser window and opening the home page
        driver.manage().window().maximize();
        driver.get("https://www.cineplex.com");

        // Handle first-time popup safely
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement okButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='OK']"))
            );
            okButton.click();
            } catch (Exception e) {
            // Popup not present, continue
        }
    }

    /*
     * This method clicks the menu button.
     */
    public void clickMenuButton() {

        // Wait for the menu button to be clickable
        WebElement menuButton = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//button[.//span[text()='Menu']]")
            )
        );

        // Click the menu button
        menuButton.click();
    }

    /*
     * This method navigates to the Gift Cards page.
     */
    public void navigateToGiftCards(){

        // Wait for the Gift Cards link to be clickable
        WebElement giftCardsLink = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(),'Gift Cards')]")
            )
        );

        // Click the Gift Cards link
        giftCardsLink.click();
    }

    /*
     * This method clicks the "Send an E-Gift Card" button.
     */
    public void clickSendEGiftCard() {

        // Wait for the "Send an E-Gift Card" button to be clickable
        WebElement sendEGiftButton = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(),'Send an E-Gift Card')]")
            )
        );

        // Click the "Send an E-Gift Card" button using JSExecutor to bypass any overlays
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sendEGiftButton);
    }

    /*
     * This method scrolls down the page and then back to the top.
     */
    public void scrollDownAndBack() throws InterruptedException {

        // Create an Actions instance
        Actions actions = new Actions(driver);

        // Scroll down a few times
        for (int i = 0; i < 5; i++) {
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            Thread.sleep(300);
        }

        // Scroll back to top
        actions.sendKeys(Keys.HOME).perform();
        actions.sendKeys(Keys.HOME).perform();
    }

    /*
     * This method enters the card value.
     */
    public void enterCardValue(String cardValue) {

        // Wait for the iframe to load and switch to it
        WebElement iframe = wait.until(
            ExpectedConditions.presenceOfElementLocated(
                By.xpath("//iframe[contains(@class,'egiftcard')]")
            )
        );
        driver.switchTo().frame(iframe);

        // Locate the card value input field
        WebElement cardValueInput = driver.findElement(By.xpath("//input[@name='card_value' and @type='number']"));

        // Scroll to the card value input field and enter the value
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cardValueInput);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='';", cardValueInput);
        cardValueInput.sendKeys("90");

        // Switch back to the default content
        driver.switchTo().defaultContent();
    }

    /*
     * This method enters the quantity.
     */
    public void enterQuantity(String quantity) {

        // Wait for the iframe to load and switch to it
        WebElement iframe = wait.until(
            ExpectedConditions.presenceOfElementLocated(
                By.xpath("//iframe[contains(@class,'egiftcard')]")
            )
        );
        driver.switchTo().frame(iframe);

        // Locate the card quantity input field
        WebElement cardQuantityInput = driver.findElement(By.xpath("//input[@name='quantity' and @type='number']"));

        // Scroll to the card quantity input field and enter the value
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cardQuantityInput);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='';", cardQuantityInput);
        cardQuantityInput.sendKeys("7");

        // Switch back to the default content
        driver.switchTo().defaultContent();
    }

    /*
     * This method enters the personal message.
     */
    public void enterPersonalMessage(String message) {

        // Wait for the iframe to load and switch to it
        WebElement iframe = wait.until(
            ExpectedConditions.presenceOfElementLocated(
                By.xpath("//iframe[contains(@class,'egiftcard')]")
            )
        );
        driver.switchTo().frame(iframe);

        // Locate the message input field
        WebElement messageField = driver.findElement(By.xpath("//textarea[@name='card_message']"));

        // Scroll to the message field, clear it, and enter the message
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", messageField);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='';", messageField);
        messageField.sendKeys("Happy Birthday!");

        // Switch back to the default content
        driver.switchTo().defaultContent();
    }

    /*
     * This method selects the delivery option.
     */
    public void selectDeliveryOption(String deliveryOption) {

        // Wait for the iframe to load and switch to it
        WebElement iframe = wait.until(
            ExpectedConditions.presenceOfElementLocated(
                By.xpath("//iframe[contains(@class,'egiftcard')]")
            )
        );
        driver.switchTo().frame(iframe);

        // Locate the self delivery option
        WebElement selfDeliveryOption = driver.findElement(By.xpath("//li[@data-delivery='print']//span[contains(text(),'Self deliver')]"));

        // Scroll to the self delivery option and click it
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selfDeliveryOption);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", selfDeliveryOption);

        // Switch back to the default content
        driver.switchTo().defaultContent();
    }

    /*
     * This method enters the recipient name.
     */
    public void enterRecipientName(String recipientName) {

        // Wait for the iframe to load and switch to it
        WebElement iframe = wait.until(
            ExpectedConditions.presenceOfElementLocated(
                By.xpath("//iframe[contains(@class,'egiftcard')]")
            )
        );
        driver.switchTo().frame(iframe);

        // Locate the recipient name input field
        WebElement nameField = driver.findElement(By.xpath("//input[@name='print_recipient_name']"));

        // Scroll to the recipient name field, clear it, and enter the name
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nameField);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='';", nameField);
        nameField.sendKeys("John Doe");

        // Switch back to the default content
        driver.switchTo().defaultContent();
    }

    /*
     * This method clicks the Add to Cart button.
     */
    public void clickAddToCart() {

        // Wait for the iframe to load and switch to it
        WebElement iframe = wait.until(
            ExpectedConditions.presenceOfElementLocated(
                By.xpath("//iframe[contains(@class,'egiftcard')]")
            )
        );
        driver.switchTo().frame(iframe);

        // Locate the Add to Cart button
        WebElement addToCartButton = driver.findElement(By.xpath("//a[contains(@class,'add-to-cart')]//span[text()='Add to cart']"));

        // Scroll to the Add to Cart button and click it
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartButton);

        // Switch back to the default content
        driver.switchTo().defaultContent();
    }

    /*
     * This method verifies that the gift cards have been added to the cart with the correct values.
     */
    public void verifyGiftCardsInCart() {

        // Wait for the iframe to load and switch to it
        WebElement iframe = wait.until(
            ExpectedConditions.presenceOfElementLocated(
                By.xpath("//iframe[contains(@class,'egiftcard')]")
            )
        );
        driver.switchTo().frame(iframe);

        // Locate the card information div
        WebElement cardInfoDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class,'card-info')]")
        ));

        // Locate the child divs containing card details
        List<WebElement> childDivs = cardInfoDiv.findElements(By.xpath(".//div"));

        // Extract the actual values from the child divs
        Map<String, String> actualValues = new HashMap<>();
        for (WebElement child : childDivs) {

            // Extract label and value
            String label = child.findElement(By.xpath("./span")).getText().replace(":", "").trim();
            String value = child.getText().replace(child.findElement(By.xpath("./span")).getText(), "").trim();

            // Store the extracted values in the map
            actualValues.put(label, value);
        }

        // Verify the extracted values
        assertEquals("$90", actualValues.get("Amount"));
        assertEquals("7", actualValues.get("Quantity"));
        assertEquals("John Doe", actualValues.get("To"));
        assertEquals("print", actualValues.get("Delivery type"));

        // Switch back to the default content
        driver.switchTo().defaultContent();
    }

    /*
     * This method verifies the card value adjustment in the gift card iframe.
     */
    public void verifyCardValueAdjustment(String maxValue) {

        // Wait for the iframe to load and switch to it
        WebElement iframe = wait.until(
            ExpectedConditions.presenceOfElementLocated(
                By.xpath("//iframe[contains(@class,'egiftcard')]")
            )
        );
        driver.switchTo().frame(iframe);

        // Locate the card value input field
        WebElement cardValueInput = driver.findElement(By.xpath("//input[@name='card_value' and @type='number']"));

        // Scroll to the card value input field
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cardValueInput);

        // Get the current value of the card value input field
        String value = cardValueInput.getAttribute("value");
        assertEquals(maxValue, value);

        // Switch back to the default content
        driver.switchTo().defaultContent();

    }

    /*
     * This method verifies the quantity adjustment in the gift card iframe.
     */
    public void verifyQuantityAdjustment(String maxQuantity) {

        // Wait for the iframe to load and switch to it
        WebElement iframe = wait.until(
            ExpectedConditions.presenceOfElementLocated(
                By.xpath("//iframe[contains(@class,'egiftcard')]")
            )
        );
        driver.switchTo().frame(iframe);

        // Locate the card quantity input field
        WebElement cardQuantityInput = driver.findElement(By.xpath("//input[@name='quantity' and @type='number']"));

        // Scroll to the card quantity input field
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cardQuantityInput);

        // Get the current value of the card quantity input field
        String quantity = cardQuantityInput.getAttribute("value");
        assertEquals(maxQuantity, quantity);

        // Switch back to the default content
        driver.switchTo().defaultContent();
    }

}
