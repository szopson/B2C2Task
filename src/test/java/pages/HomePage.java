package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitUtils;

import java.util.List;

public class HomePage extends BasePage {
    // Locators
    private final By navigationMenu = By.cssSelector(".nav_menu_wrap  div[data-hover='true']");
    private final By links = By.tagName(".nav-menu_inner_wrap a ");
    private final By menuContact = By.cssSelector(".nav-menu_inner_wrap a[href='/contact-us']");


    // Constructor
    public HomePage() {
        super();
    }

    // Navigate to the Homepage
    public void navigateToHomepage() {
        String baseUrl = configReader.getProperty("baseUrlFront");
        driver.get(baseUrl);
    }

    // Page actions
    public boolean isPageLoaded() {
        WebDriverWait wait = WaitUtils.getWait(driver);
        return wait.until(ExpectedConditions.titleContains("B2C2"));
    }

    public boolean isNavigationMenuClickable() {
        return driver.findElement(navigationMenu).isDisplayed() &&
                driver.findElement(navigationMenu).isEnabled();
    }

    public boolean areMenuItemsCorrect(List<String> expectedTexts) {
        List<WebElement> menuItems = driver.findElements(navigationMenu);
        if (menuItems.size() != expectedTexts.size()) {
            return false; // Size mismatch means some items are missing
        }
        for (int i = 0; i < menuItems.size(); i++) {
            WebElement item = menuItems.get(i);
            String expectedText = expectedTexts.get(i);
            if (!item.isDisplayed() || !item.getText().equals(expectedText)) {
                return false; // Either the item is not displayed or the text does not match
            }
        }
        return true; // All items displayed and contain the correct text
    }

    public boolean areAllLinksCorrect(List<String> expectedUrlParts) {
        List<WebElement> linksList = driver.findElements(links);
        // Example way to check links, might need actual URL checks
        return linksList.stream()
                .allMatch(link -> expectedUrlParts.stream()
                        .anyMatch(part -> link.getAttribute("href").contains(part)));
    }

    public WebElement getMenuLink(String linkEnd) {
        return driver.findElement(By.cssSelector(".nav_menu_wrap a[href='" + linkEnd + "']"));
    }



}