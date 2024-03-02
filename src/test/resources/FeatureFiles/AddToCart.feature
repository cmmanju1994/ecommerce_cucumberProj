Feature: Add to cart Functionality

  Scenario: Verify Products successfully added to cart
    Given user navigates to home page
    When user Click on Products button
    Then user navigated to ALL PRODUCTS page successfully
    When user mouse hover on first product and click on add to cart
    And user click on continue shopping button
    And user mouse hover on second product and click on add to cart
    And user click on view cart link
    Then both products have been added to cart successfully
    And unit price,qty and total price is visible
