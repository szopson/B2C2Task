package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitUtils;

import java.util.Arrays;
import java.util.List;

public class ContactPage extends BasePage {

    //Locators
    private final By contactForm = By.cssSelector("form#wf-form-Email-Form-2-Contact-Page");
    private final By menuContact = By.cssSelector(".nav-menu_inner_wrap a[href='/contact-us']");

    private final By nameField = By.cssSelector("#Name");
    private final By emailField = By.cssSelector("#email");
    private final By companyField = By.cssSelector("#Company");
    private final By positionField = By.cssSelector("#Position-at-company-2");

    private final By contactDropdown = By.xpath("//select[@id='What-Best-Describes-Your-Organisation-4']");
    private final By organisationDropdown = By.xpath("//select[@id='What-Best-Describes-Your-Organisation-3']");
    private final By volumeDropdown = By.xpath("//select[@id='What-Best-Describes-Your-Organisation-5']");


    public ContactPage() {
        super();
    }

    public boolean allFieldsAreOperational() {
        List<By> operationalFields = Arrays.asList(nameField, emailField, companyField, positionField);
        return operationalFields.stream()
                .allMatch(this::isElementOperational);
    }

    public boolean allDropDownsAreOperational() {
        List<By> dropDowns = Arrays.asList(contactDropdown, volumeDropdown, organisationDropdown);
        return dropDowns.stream().allMatch(this::isDropDownValid);
    }

    public void goToContactPage() {
        driver.findElement(menuContact).isDisplayed();
        driver.findElement(menuContact).click();
    }

    public boolean isPageLoaded() {
        WebDriverWait wait = WaitUtils.getWait(driver);
        return wait.until(ExpectedConditions.titleContains("Contact")) && driver.findElement(contactForm).isDisplayed();
    }
}