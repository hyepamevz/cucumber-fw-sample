package steps;

import core.BaseTest;
import core.ConfigReader;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.ElementPage;

import java.util.Arrays;
import java.util.List;

public class ElementSteps {

    WebDriver driver;
    ElementPage elementPage;

    @Given("user is on Dropdown-Checkboxes-RadioButtons page")
    public void user_is_on_Dropdown_Checkboxes_RadioButtons_page() {
        driver = BaseTest.getDriver();
        elementPage = new ElementPage(driver);
        elementPage.navigateTo((ConfigReader.getPageUrl("elementPageURL")));
    }

    @When("user click on the dropdown {string}")
    public void user_click_on_the_dropdown(String dropdownName) {
        elementPage.clickDropdown(dropdownName);
    }

    @Then("the user can see the option {string} in dropdown {string}")
    public void the_user_can_see_the_option_in_dropdown(String options, String dropdownName) {
        List<String> optionList = Arrays.stream(options.split(", ")).sorted().toList();
        Assert.assertTrue(elementPage.isOptionVisibled(dropdownName, optionList));
    }
}
