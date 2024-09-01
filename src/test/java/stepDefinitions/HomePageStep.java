package stepDefinitions;


import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import utils.DriverFactory;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class HomePageStep {
    HomePage homePage = new HomePage();

    @Given("the user navigates to the homepage")
    public void the_user_navigates_to_the_homepage() {
        homePage.navigateToHomepage();
    }


    @Then("the page should load within an acceptable time")
    public void the_page_should_load_within_an_acceptable_time() {
        assertTrue("Page did not load in time", homePage.isPageLoaded());
    }

    @Then("the main navigation menu should be visible and clickable")
    public void the_main_navigation_menu_should_be_visible_and_clickable() {
        assertTrue("Navigation menu is not visible and clickable", homePage.isNavigationMenuClickable());
    }

    @Then("all key sections should display accurate information")
    public void all_key_sections_should_display_accurate_information() {
        List<String> expectedTexts = Arrays.asList("Solutions", "About", "News & Events", "Institutional Insight", "Join B2C2");
        assertTrue("Menu items are not as expected", homePage.areMenuItemsCorrect(expectedTexts));
    }


    @Then("all links on the homepage should lead to the correct pages")
    public void all_links_on_the_homepage_should_lead_to_the_correct_pages() {
        List<String> expectedUrlParts = Arrays.asList("/solutions", "/solutions/trading-overview", "/solutions/product", "solutions/liquidity-partner",
                "/about", "about/about-us", "/about/meet-the-team", "/about/membership", "/about/faqs", "/news-and-events", "/news-events/events", "/insights", "/insights/cryptobits", "/insights/thought-leadership", "/insights/podcast", "insights/videos", "/insights/employee-spotlights", "/join-b2c2", "/join-b2c2/our-values", "/join-b2c2/careers");
        assertTrue("Not all links contain the expected URL parts", homePage.areAllLinksCorrect(expectedUrlParts));
    }

    @When("the user clicks on the {string} link in the menu")
    public void the_user_clicks_on_the_link_in_the_menu(String linkText) {
        homePage.getMenuLink(linkText).click();
    }

    @Then("the user should be taken to a page with the title {string}")
    public void the_user_should_be_taken_to_a_page_with_the_title(String expectedTitle) {
        String actualTitle = homePage.getTitle();
        assertTrue("The page title does not match the expected title.", actualTitle.contains(expectedTitle));
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
