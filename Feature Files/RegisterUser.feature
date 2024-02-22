Feature: Register Functionality

  Scenario: Register User With Required Details
    Given user navigates to home page
    When user click on Signup / Login button
    Then "New User Signup!" is visible
    When user enter name and email address
    And click on Signup button
    #Then "ENTER ACCOUNT INFORMATION" is visible
    When user fill details Title, Name, Email, Password, Date of birth
    And Select checkbox "Sign up for our newsletter!"
    And Select checkbox "Receive special offers from our partners!"
    And Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number.
    And Click Create Account button
    Then ACCOUNT CREATED! messeage is visible
    When user Click on Continue button
    Then Logged in as username is visible
    When user Click on Delete Account button
    Then ACCOUNT DELETED! is visible and click Continue button
