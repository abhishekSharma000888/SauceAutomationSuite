Feature:
  Scenario: User add a product to the Cart
    Given I am logged in with username "standard_user" and password "secret_sauce"
    When I add the product "Sauce Labs Backpack" to the cart
    Then the product "Sauce Labs Backpack" should be present in the cart