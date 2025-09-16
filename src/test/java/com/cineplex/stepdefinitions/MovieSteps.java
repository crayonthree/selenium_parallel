/*
 * MovieSteps.java
 * This class contains all step definitions for Movie Scenarios.
 * Author: Abhiroop Yerramilli
 * Date: 22 August 2025
 * Project: Cineplex Automation testing using Selenium + Cucumber
 */

 package com.cineplex.stepdefinitions;


import com.cineplex.actions.MoviePageActions;
import com.cineplex.utils.DriverUtilities;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/*
 * This class contains all step definitions for Movie Scenarios.
 */
public class MovieSteps {

    // Variables
    private MoviePageActions moviePage;

    // Constructor
    public MovieSteps() {
        // Initialize the MoviePageActions with the WebDriver instance
        this.moviePage = new MoviePageActions(DriverUtilities.getInstance().getDriver());
    }

    // Step definitions for account-related actions

    @When("User searches for {string}")
    public void user_searches_for(String movieName) {
        moviePage.searchForMovie(movieName);
    }

    @When("User selects the movie {string} from the search results")
    public void user_selects_movie_from_search_results(String movieName) {
        moviePage.selectMovieFromSearchResults(movieName);
    }

    @Then("Movie title should be displayed as {string}")
    public void movie_title_should_be_displayed(String expectedTitle) {
        moviePage.verifyMovieTitleDisplayed(expectedTitle);
    }


    @Then("The runtime should be visible as {string}")
    public void the_runtime_should_be_visible(String expectedRuntime) {
        moviePage.verifyMovieRuntimeVisible(expectedRuntime);
    }

    @Then("The genre should be visible as {string}")
    public void the_genre_should_be_visible(String expectedGenre) {
        moviePage.verifyMovieGenreVisible(expectedGenre);
    }

    @Then("The rating should be visible as {string}")
    public void the_rating_should_be_visible(String expectedRating) {
        moviePage.verifyMovieRatingVisible(expectedRating);
    }

}
