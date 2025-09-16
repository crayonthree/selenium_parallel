Feature: Movie Experience

  Scenario Outline: User views basic movie details
    Given User opens the Cineplex homepage
    When User searches for "<MovieName>"
    And User selects the movie "<MovieName>" from the search results
    Then Movie title should be displayed as "<MovieName>"
    And The runtime should be visible as "<Runtime>"
    And The genre should be visible as "<Genre>"
    And The rating should be visible as "<Rating>"
  Examples:
    | MovieName    | Runtime  | Genre                       | Rating |
    | Relay  | 1h 52min | Action, Thriller             | 14A  |
    | Nobody 2     | 1h 29min | Comedy, Crime, Thriller     | 14A    |
    | How to Train Your Dragon   | 2h 6min | Action, Adventure  | PG  |