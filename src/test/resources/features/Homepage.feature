Feature: Homepage Navigation and Content

  Background:
    Given the user navigates to the homepage
    Then the page should load within an acceptable time

  Scenario: Verify the homepage loads correctly and all elements are functional
    And the main navigation menu should be visible and clickable
    And all key sections should display accurate information
    And all links on the homepage should lead to the correct pages

  Scenario Outline: Verify that clicking on each nav main menu link navigates to the correct page
    When the user clicks on the "<link>" link in the menu
    Then the user should be taken to a page with the title "<title>"

    Examples:
      | link             | title           |
      | /solutions       | Solutions       |
      | /about           | About           |
      | /news-and-events | News and Events |
      | /insights        | Insights        |
      | /join-b2c2       | Join B2C2       |
      | /contact-us      | Contact         |