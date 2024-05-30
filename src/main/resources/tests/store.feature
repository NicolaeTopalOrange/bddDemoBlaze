Feature: Buy item

  @regressionPack
  Scenario Outline: Buy device
    Given open application
    When user select phone category
    And user waits till page is loaded
    And user selects "<phone>" device
    And user waits till page is loaded
    And user should see the selected "<phone>" page
    And user clicks add to cart
    Then user should see an alert with "Product added" message
    And user navigates to cart
    And user waits till page is loaded
    And user checks if correct "<phone>" is in cart
    And user clicks place order button
    And user enters the name "<name>"
    And user enters the country "<country>"
    And user enters city "<city>"
    And user enters credit card "<credit card>"
    And user enters month "<month>"
    And user enters year "<year>"
    And user click purchase button
    And user waits till page is loaded
    Then user should receive the order summary


    Examples:
      | phone              | city      | country     | name              | credit card      | month | year |
      | Nokia lumia 1520   | Chisinau  | Moldova     | Green PowerRanger | 7777888855553333 | 02    | 1993 |
