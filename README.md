# Task
Create a basic framework to run chosen tests against a b2c2 website: https://www.b2c2.com/, the framework be written in Java, Cucumber

## Attitude
I have chosen basic fields and main links checked from the navigation menu, as well as the contact form.
Most important from the user perspective is the ability to subscribe and contact the B2C2 company,
however, CAPTCHA is required to do that so I skip that part in my tests. I wanted to keep it simple and demonstrate a basic framework creation understanding.

# Framework overview
This automation framework is designed for UI testing of B2C2 web applications using Selenium WebDriver and Cucumber. 
The framework utilizes the Page Object Model (POM) to promote code reusability and maintainability.

## Prerequisites
- Java 8 or higher
- Maven

## Technologies Used
- **Selenium WebDriver**: For browser automation.
- **Cucumber**: For writing test cases in Gherkin syntax, BDD testing.
- **Maven**: Dependency management and project build.
- **WebDriverManager**: Automatically managing driver binaries for Selenium.

# Framework Structure
**POM(pages)**:
 - **BasePage**: Foundational class that can encapsulate all the common functionality and attributes that are shared across different pages within a web application
 - **HomePage**: In other words the landing page, I focused on checking the navigation menu
 - **ContactPage**: On the second page I have checked, I focused on validating fields inside the contact form

**Utils**
- **ConfigReader**: Management of configuration settings, in our case, it is the config.properties file
- **DriverFactory**: Creating and managing instances of WebDriver. The whole process is partially handled by WebDriverManager library

**stepDefinitions**
- Implementation of feature file steps. I have separated steps based on POM, each page has its own stepDefinition file

**features**
- BDD style, I have used keywords like "Background" and "Scenario Outline" to avoid step duplication

# How to RUN:

   ```sh
   mvn clean test
   ```
