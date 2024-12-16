package steps;

import core.BasePage;
import core.BaseTest;
import core.ConfigReader;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.ContactPage;

public class BaseSteps {

    WebDriver driver;
    BasePage basePage;

    @Given("user is on {string} page")
    public void user_is_on_page(String page) {
        driver = BaseTest.getDriver();
        basePage = new BasePage(driver);
        basePage.navigateTo((ConfigReader.getPageUrl(page+"URL")));
    }
}
