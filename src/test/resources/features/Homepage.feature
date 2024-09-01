Feature: Homepage Navigation and Content

  Scenario: Verify the homepage loads correctly and all elements are functional
    Given the user navigates to the homepage
    Then the page should load within an acceptable time
    And the main navigation menu should be visible and clickable
    And all key sections should display accurate information
    And all links on the homepage should lead to the correct pages
