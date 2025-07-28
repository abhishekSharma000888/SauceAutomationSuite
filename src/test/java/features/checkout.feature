Feature: Checkout process

  Scenario: User completes checkout after adding a product to cart
    Given I am logged in with username "standard_user" and password "secret_sauce"
    And I add the product "Sauce Labs Backpack" to the cart
    When I proceed to checkout
    And I enter first name "John", last name "Doe", and zip code "12345"
    And I finish the checkout process
    Then I should see the confirmation message "Thank you for your order!"
