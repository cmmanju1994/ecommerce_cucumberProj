Feature: Login Functionality
  
  Scenario:Login using correct email id and password
  
  Given user navigates to home page
  When user click on Signup / Login button
  Then Login to your account visible
  When user enter email adress as "anvita123@gmail.com"
  And Password as "test@123"
  And click on login button
  Then user navigated to My account Page
