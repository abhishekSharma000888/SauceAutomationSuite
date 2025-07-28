
  Feature: Login

    Scenario: Successful login with valid credentials
      Given user is on the login page
      When user enters username "standard_user" and password "secret_sauce"
      And user clicks on login button
      Then user should be navigated to the products page