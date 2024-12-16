package steps;

import core.BaseTest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import java.util.List;
import java.util.Map;

public class LoginSteps {
    WebDriver driver = BaseTest.getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @When("the user login with credentials: {string} {string}")
    public void the_user_login_with_credentials(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("the user see the warning alert")
    public void the_user_see_the_warning_alert() {
        Assert.assertTrue(loginPage.verifyWarningAlertExist());
    }
}
