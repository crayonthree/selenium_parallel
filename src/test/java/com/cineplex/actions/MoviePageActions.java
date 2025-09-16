/*
 * MoviePageActions.java
 * This class contains helper methods to all step definitions for Movie Scenarios.
 * Author: Abhiroop Yerramilli
 * Date: 22 August 2025
 * Project: Cineplex Automation testing using Selenium + Cucumber
 */

package com.cineplex.actions;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * This class contains all actions for the Movie Features.
 */
public class MoviePageActions {

    //Private variables
    private WebDriver driver;
    private WebDriverWait wait;

    //Constructor
    public MoviePageActions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    

    /*
     * This method searches for a movie by name.
     */
    public void searchForMovie(String movieName) {
        driver.findElement(By.xpath("//button[.//span[text()='Search']]")).click();

        // Wait for the search box to be visible
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[contains(@data-testid,'search') and @type='text']"))
        );

        // Scroll to the search box
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchBox);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='';", searchBox);

        // Enter the movie name and submit the search
        searchBox.sendKeys(movieName);
        searchBox.sendKeys(Keys.RETURN);
    }

    /*
     * This method selects a movie from the search results.
     */
    public void selectMovieFromSearchResults(String movieName) {

        // Wait for the movie link to be visible
        WebElement movieLink = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//img[@alt='" + movieName + "']")
        ));

        // Click on the movie link
        movieLink.click();
    }

    /*
     * This method verifies that the movie title is displayed correctly.
     */
    public void verifyMovieTitleDisplayed(String expectedTitle) {

        // Wait for the movie title to be visible
        WebElement movieTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[@data-testid='movie-title']"))
        );

        // Verify the movie title
        assertEquals(expectedTitle, movieTitle.getText().trim());
    }

    /*
     * This method verifies that the movie runtime is displayed correctly.
     */
    public void verifyMovieRuntimeVisible(String expectedRuntime) {

        // Wait for the movie runtime to be visible
        WebElement runtimeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[@data-testid='movie-length']"))
        );

        // Verify the movie runtime
        assertEquals(expectedRuntime, runtimeElement.getText().trim());
    }

    /*
     * This method verifies that the movie genre is displayed correctly.
     */
    public void verifyMovieGenreVisible(String expectedGenre) {

        // Wait for the movie genre to be visible
        WebElement genreElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[@data-testid='genres']"))
        );

        // Verify the movie genre
        assertEquals(expectedGenre, genreElement.getText().trim());
    }

    /*
     * This method verifies that the movie rating is displayed correctly.
     */
    public void verifyMovieRatingVisible(String expectedRating) {

        // Wait for the movie rating to be visible
        WebElement ratingElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[contains(@class,'cpx-body-bold')]"))
        );

        // Verify the movie rating
        assertEquals(expectedRating, ratingElement.getText().trim());
    }

    /*
     * This method verifies that the movie release date is displayed correctly.
     */
    public void verifyMovieReleaseDateVisible(String releaseDate) {

        // Wait for the movie release date to be visible
        WebElement releaseDateElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[@data-testid='release-date']"))
        );

        // Verify the movie release date
        assertEquals(releaseDate, releaseDateElement.getText().trim());
    }
}
