Feature: Search Functionality

  Scenario: Search product and verify related products
    Given user navigates to home page
    When user Click on Products button
    Then user navigated to ALL PRODUCTS page successfully
    When user enter product name in search box and click search button
    Then searched product is visible
    And search related products also visible
