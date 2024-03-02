Feature: Product quantity in cart

  Scenario: Verifying product quantity in cart
    Given user navigates to home page
    When user Click on Products button
    When user click on view product for any product
    Then details of the product is visible
    When user increase the quantity to 4
    And click on add to cart button
    And click view cart button
    Then verify total quanity as 4 in the cart
