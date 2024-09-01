package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;
import utils.DriverFactory;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected ConfigReader configReader;

    public BasePage() {
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Example timeout
        this.configReader = ConfigReader.getInstance(); // Accessing the singleton instance
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public WebElement getField(String fieldId) {
        return driver.findElement(By.id(fieldId));
    }

    public void setInputField(String fieldId, String input) {
        WebElement field = getField(fieldId);
        field.clear();
        field.sendKeys(input);
    }

    public String getInputFieldText(String fieldId) {
        return getField(fieldId).getAttribute("value");
    }

    public Select getTheDropDown(By elementId) {
        WebElement dropdownElement = driver.findElement(elementId);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdownElement);
        return new Select(dropdownElement);
    }

    public boolean isDropDownValid(By elementId) {
        return !getTheDropDown(elementId).getOptions().isEmpty();
    }

    // Check if element is displayed and enabled for interaction
    public boolean isElementOperational(By elementId) {
        WebElement element = driver.findElement(elementId);
        return element.isDisplayed() && element.isEnabled();
    }

    // Method to check if textarea is visible
    public boolean isTextareaVisible(String textareaId) {
        return driver.findElement(By.id(textareaId)).isDisplayed();
    }

    // Method to enter text into textarea
    public void enterTextInTextarea(String textareaId, String text) {
        WebElement textarea = driver.findElement(By.id(textareaId));
        textarea.clear();
        textarea.sendKeys(text);
    }

    // Method to get text from textarea
    public String getTextFromTextarea(String textareaId) {
        return driver.findElement(By.id(textareaId)).getAttribute("value");
    }

}
