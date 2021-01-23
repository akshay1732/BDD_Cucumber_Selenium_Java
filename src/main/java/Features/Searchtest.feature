Feature: Test Google Search Page

  @SmokeTest
  Scenario Outline: Test search button on google search page

    Given User is on Google search page
    Then Enter "<value>" to search in search box
    And Click on google search button


    Examples:
      | value    |
      | Amazon   |
      | Flipkart |


  Scenario Outline: Test I am feeling lucky button on google search page

  Given User is on Google search page
  Then Enter "<value>" to search in search box
  And Click on I am feeling lucky button

    Examples:
      |value|
      |Unsplash|
      |Flipkart|