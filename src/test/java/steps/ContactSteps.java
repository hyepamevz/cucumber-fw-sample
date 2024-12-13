package steps;

import core.BaseTest;
import core.ConfigReader;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.ContactPage;

public class ContactSteps {

    WebDriver driver;
    ContactPage contactPage;

    @Given("user is on contact page")
    public void user_is_on_contact_page() {
        driver = BaseTest.getDriver();
        contactPage = new ContactPage(driver);
        contactPage.navigateTo((ConfigReader.getPageUrl("contactURL")));
    }

    @When("the user submit name and email")
    public void the_user_submit_name_and_email() {
        contactPage.submitContact();
    }

    @Then("the user can see the thank you message")
    public void the_user_can_see_the_thank_you_message() {
        Assert.assertTrue(contactPage.isThankYouMessageDisplayed());
    }
}
