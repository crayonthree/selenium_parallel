/*
 * GiftCardPageSteps.java
 * This class contains all step definitions for Gift Card Scenarios.
 * Author: Abhiroop Yerramilli
 * Date: 22 August 2025
 * Project: Cineplex Automation testing using Selenium + Cucumber
 */
package com.cineplex.stepdefinitions;

import com.cineplex.actions.GiftCardPageActions;
import com.cineplex.utils.DriverUtilities;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/*
 * Step definitions for gift card-related actions
 */
public class GiftCardSteps {

    // Variables
    private GiftCardPageActions giftCardPage;

    // Constructor
    public GiftCardSteps() {
        // Initialize the GiftCardPageActions with the WebDriver instance
        this.giftCardPage = new GiftCardPageActions(DriverUtilities.getInstance().getDriver());
    }

    // Step definitions for gift card-related actions
    @Given("User opens the Cineplex homepage")
    public void user_opens_cineplex_homepage() {
        giftCardPage.openHomePage();
    };

    @Given("User clicks on the Menu button")
    public void user_clicks_on_menu_button() {
        giftCardPage.clickMenuButton();
    }

    @Given("User navigates to Gift Cards")
    public void user_navigates_to_gift_cards() {
        giftCardPage.navigateToGiftCards();
    }

    @When("User clicks Send an E-Gift Card")
    public void user_clicks_send_e_gift_card() {
        giftCardPage.clickSendEGiftCard();
    }

    @When("User scrolls down the page a few times and back to top")
    public void user_scrolls_down_and_back() throws InterruptedException {
        giftCardPage.scrollDownAndBack();
    }

    @When("User enters {string} as the card value")
    public void user_enters_card_value(String cardValue) {
        giftCardPage.enterCardValue(cardValue);
    }

    @When("User enters {string} as the quantity")
    public void user_enters_quantity(String quantity) {
        giftCardPage.enterQuantity(quantity);
    }

    @When("User enters {string} as the personal message")
    public void user_enters_personal_message(String message) {
        giftCardPage.enterPersonalMessage(message);
    }

    @When("User selects {string} as the delivery option")
    public void user_selects_delivery_option(String deliveryOption) {
        giftCardPage.selectDeliveryOption(deliveryOption);
    }

    @When("User enters {string} as the recipient name")
    public void user_enters_recipient_name(String recipientName) {
        giftCardPage.enterRecipientName(recipientName);
    }

    @When("User clicks Add to cart to complete the selection")
    public void user_clicks_add_to_cart() {
        giftCardPage.clickAddToCart();
    }

    @Then("the gift cards should be added to the cart with the correct values")
    public void the_gift_cards_should_be_added_to_cart_with_correct_values() {
        giftCardPage.verifyGiftCardsInCart();
    }

    @Then("the gift card value field should automatically adjust to the maximum allowed {string}")
    public void the_gift_card_value_field_should_automatically_adjust(String maxValue) {
        giftCardPage.verifyCardValueAdjustment(maxValue);
    }

    @Then("the quantity field should automatically adjust to the maximum allowed {string}")
    public void the_quantity_field_should_automatically_adjust(String maxQuantity) {
        giftCardPage.verifyQuantityAdjustment(maxQuantity);
    }
}
