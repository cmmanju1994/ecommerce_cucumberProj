Feature: Place order

  Scenario: Register while placing the order
    Given user navigates to home page
    And user added product to the cart
    And click on view cart
    Then cart page is displayed
    When user click on proceed to checkout
    Then Register/login link appears
    When user click on the Register/login link
    Then user navigated to Signup/Login page
    When user fill required details
    Then Account created messeage get displayed
    And logged in as user displayed at top
    When user clicks on cart button
    Then User navigated to cart page
    When user click on proceed to checkout
    Then address detials visible and review order product
    When user enter comment and click on place order button
    Then user navigated to payment page
    When user enter card details below fields
      | Name on card     | Anvita       |
      | card number      | 124521544512 |
      | CVC              |          123 |
      | Expiration_month |           12 |
      | Expiration_year  |         2026 |
    And click on Pay and confirm order button
    Then Congratulations! Your order has been confirmed! messeage is displayed
