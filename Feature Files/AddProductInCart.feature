Feature: Add to cart

  Scenario: Verify add to cart functionality
    Given user navigates to home page
    When user Click on Products button
    Then all products are displayed on the page
    When mouse over first product and click on add to cart button
    And click continue shopping button
    And mouse over second product and click on view cart link
    Then both products are added to cart
    And prices,quantity and total price visible
