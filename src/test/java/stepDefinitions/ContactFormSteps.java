package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.ContactPage;
import utils.DriverFactory;

import static org.junit.Assert.assertTrue;

public class ContactFormSteps {
    ContactPage contactPage = new ContactPage();

    @And("the user goes to the contact page")
    public void theUserGoesToTheContactPage() {
        contactPage.goToContactPage();
    }

    @Then("the contact page should load within an acceptable time")
    public void the_page_should_load_within_an_acceptable_time() {
        assertTrue("Page did not load in time", contactPage.isPageLoaded());
    }

    @Then("all input fields should be visible and operational")
    public void all_input_fields_should_be_visible_and_operational() {
        Assert.assertTrue(contactPage.allFieldsAreOperational());
    }

    @Then("all dropdowns should be visible and have options")
    public void all_dropdowns_should_be_visible_and_haveOptions() {
        Assert.assertTrue(contactPage.allDropDownsAreOperational());
    }

    @When("the user inputs {string} into {string}")
    public void the_user_inputs_into(String input, String fieldId) {
        contactPage.setInputField(fieldId, input);
    }

    @Then("the {string} should display the input {string}")
    public void the_field_should_display_the_input(String fieldId, String expectedInput) {
        Assert.assertEquals(expectedInput, contactPage.getInputFieldText(fieldId));
    }

    @When("the user views the {string} textarea")
    public void the_user_views_the_textarea(String textareaId) {
        Assert.assertTrue("Textarea should be visible", contactPage.isTextareaVisible(textareaId));
    }

    @Then("the {string} textarea should be visible")
    public void the_textarea_should_be_visible(String textareaId) {
        Assert.assertTrue("Textarea should be visible", contactPage.isTextareaVisible(textareaId));
    }

    @Then("the user can enter {string} into the {string}")
    public void the_user_can_enter_into_the(String text, String textareaId) {
        contactPage.enterTextInTextarea(textareaId, text);
        Assert.assertEquals("Text entered in the textarea should match", text, contactPage.getTextFromTextarea(textareaId));
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}