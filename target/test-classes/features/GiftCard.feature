Feature: Gift Card Purchase

  Scenario: User can select and send an E-Gift Card with verification
    Given User opens the Cineplex homepage
    And User clicks on the Menu button
    And User navigates to Gift Cards
    When User clicks Send an E-Gift Card
    And User scrolls down the page a few times and back to top
    And User enters "90" as the card value
    And User enters "7" as the quantity
    And User enters "Happy Birthday!" as the personal message
    And User selects "Self deliver" as the delivery option
    And User enters "John Doe" as the recipient name
    And User clicks Add to cart to complete the selection
    Then the gift cards should be added to the cart with the correct values

  Scenario: User tries to enter a gift card value exceeding the maximum allowed
    Given User opens the Cineplex homepage
    And User clicks on the Menu button
    And User navigates to Gift Cards
    When User clicks Send an E-Gift Card
    And User scrolls down the page a few times and back to top
    And User enters "250" as the card value
    And User enters "7" as the quantity
    Then the gift card value field should automatically adjust to the maximum allowed "200"

  Scenario: User tries to enter a gift card quantity exceeding the maximum allowed
    Given User opens the Cineplex homepage
    And User clicks on the Menu button
    And User navigates to Gift Cards
    When User clicks Send an E-Gift Card
    And User scrolls down the page a few times and back to top
    And User enters "90" as the card value
    And User enters "35" as the quantity
    Then the quantity field should automatically adjust to the maximum allowed "7"    