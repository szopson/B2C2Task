package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    By navigationMenu = By.cssSelector(".nav_menu_wrap");
    By keySections = By.className("key-section");
    By links = By.tagName("a");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isPageLoaded() {
        return driver.getTitle().contains("B2C2");
    }

    public boolean isNavigationMenuClickable() {
        return driver.findElement(navigationMenu).isDisplayed() &&
                driver.findElement(navigationMenu).isEnabled();
    }

    public boolean areKeySectionsPresent() {
        return driver.findElements(keySections).size() > 0;
    }

    public boolean areLinksWorking() {
        return driver.findElements(links).stream().allMatch(link -> link.getAttribute("href").contains("b2c2.com"));
    }
}