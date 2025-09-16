/*
 * AccountSteps.java
 * This class contains all step definitions for Account Management Scenarios.
 * Author: Abhiroop Yerramilli
 * Date: 22 August 2025
 * Project: Cineplex Automation testing using Selenium + Cucumber
 */

package com.cineplex.stepdefinitions;

import com.cineplex.actions.AccountPageActions;
import com.cineplex.utils.DriverUtilities;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

/*
 * This class contains step definitions for account-related actions.
 */
public class AccountSteps {

    // Page Actions
    private AccountPageActions loginPage;

    // Constructor
    public AccountSteps() {
        // Initialize the LoginPageActions with the WebDriver instance
        this.loginPage = new AccountPageActions(DriverUtilities.getInstance().getDriver());
    }

    // Step definitions for account-related actions

    @Given("User is on the login page")
    public void userIsOnTheLoginPage() {
        loginPage.openLoginPage();
    }

    @When("User enters email {string} and password {string}")
    public void user_enters_email_and_password(String email, String password) {
        loginPage.enterCredentials(email,password);
    }

    @When("User clicks the login button")
    public void userClicksTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("User should be redirected to setup 2-Step Verification after successful login")
    public void userShouldBeRedirectedToSetup2StepVerificationAfterSuccessfulLogin() {
        // Implement the step definition
        loginPage.verifyTwoStepVerificationPage();
    }

    @Then("User should see an error message")
    public void userShouldSeeAnErrorMessage() {
        // Implement the step definition
        loginPage.verifyErrorMessage();
    }
}
