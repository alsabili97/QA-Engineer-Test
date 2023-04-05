@tag
Feature: I want to checkout order product watch
	@tag1
  Scenario: I want to Checkout product to complete
    Given I visit URL jam tangan.com
    And I login my account
    When I see dashboard jamtangan and click product add to cart
    And I check out Order
    Then Success checkout order
    And I see amount is same with previous page