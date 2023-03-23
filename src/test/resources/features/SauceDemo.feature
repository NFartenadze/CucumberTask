Feature: Sauce Demo Order Checkout testing


  Scenario: Checking out Orders
    Given I am on login page
    When I login, product page loads
    Then I add user's products to cart
    Then I open cart page
    And I checkout user's orders