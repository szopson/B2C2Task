Feature: Contact Form Functionality

  Scenario: Verify that the contact form can be submitted successfully
    Given the user navigates to the contact page
    When the user fills out the contact form with valid details
    And submits the form
    Then the form should be submitted without errors
    And a confirmation message should be displayed to the user
    And the user should receive a confirmation email