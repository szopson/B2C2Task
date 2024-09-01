Feature: Contact Form Smoke Test

  Background:
    Given the user navigates to the homepage
    And the user goes to the contact page
    Then the contact page should load within an acceptable time

  Scenario: Verify all input fields and dropdowns are visible and operational
    Then all input fields should be visible and operational
    And all dropdowns should be visible and have options

  Scenario Outline: Input field validation
    When the user inputs "<input>" into "<fieldId>"
    Then the "<fieldId>" should display the input "<input>"

    Examples:
      | fieldId               | input            |
      | Name                  | John Doe         |
      | email                 | john@example.com |
      | Company               | Example Inc.     |
      | Position-at-company-2 | Developer        |

  Scenario: Verify textarea functionality
    When the user views the "Message" textarea
    Then the "Message" textarea should be visible
    And the user can enter "This is a test message." into the "Message"