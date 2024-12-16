package steps;

import core.BaseTest;
import core.ConfigReader;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.ContactPage;

public class ContactSteps {

    WebDriver driver = BaseTest.getDriver();
    ContactPage contactPage = new ContactPage(driver);

    @When("the user submit fields")
    public void the_user_submit_name_and_email() {
        contactPage.submitContact();
    }

    @Then("the user can see the thank you message")
    public void the_user_can_see_the_thank_you_message() {
        Assert.assertTrue(contactPage.isThankYouMessageDisplayed());
    }
}
