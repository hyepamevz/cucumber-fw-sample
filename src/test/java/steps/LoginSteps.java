package steps;

import core.BaseTest;
import core.ConfigReader;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        driver = BaseTest.getDriver();
        loginPage = new LoginPage(driver);
        loginPage.navigateTo((ConfigReader.getPageUrl("loginURL")));
    }

    @When("the user login with {string} and {string}")
    public void the_user_login_with_credentials(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("the user see the warning alert")
    public void the_user_see_the_warning_alert() {
        Assert.assertTrue(loginPage.verifyWarningAlertExist());
    }
}
