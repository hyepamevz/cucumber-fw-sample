package steps;

import core.BasePage;
import core.BaseTest;
import core.ConfigReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.ElementPage;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ElementSteps {

    WebDriver driver = BaseTest.getDriver();
    ElementPage elementPage = new ElementPage(driver);

    @Then("the user can see the option {string} in dropdown {string}")
    public void the_user_can_see_the_option_in_dropdown(String options, String dropdownName) {
        List<String> optionList = Arrays.stream(options.split(", ")).sorted().toList();
        Assert.assertTrue(elementPage.isOptionVisibled(dropdownName, optionList));
    }

    @Then("the user can see the option in each dropdown:")
    public void the_user_can_see_the_option(DataTable dataTable) {
        List<Map<String, String>> dataMaps = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> data : dataMaps) {
            String dropdown = data.get("dropdown");
            String opt = data.get("option");
            Assert.assertTrue(elementPage.isOptionVisibled(dropdown, Arrays.stream(opt.split(", ")).sorted().toList()));
        }
    }

    @When("user select {string} in dropdown {string}")
    public void user_select_value_in_dropdown(String option, String dropdownName) {
        elementPage.selectDropdownByText(option, dropdownName);
    }

    @Then("the user can see option {string} is selected in dropdown {string}")
    public void the_user_can_see_option_value_is_selected(String value, String dropdownName) {
        elementPage.isSelectedOptionVisible(value, dropdownName);
    }
}
