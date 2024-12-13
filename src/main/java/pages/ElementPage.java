package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ElementPage extends BasePage {
    public ElementPage(WebDriver driver) {
        super(driver);
    }

    public void clickDropdown(String dropdown) {
        this.waitUntilVisibilityOf(driver.findElement(By.id(dropdown))).click();
    }

    public boolean isOptionVisibled(String dropdownName, List<String> optionList) {
        return optionList.equals(getOptionValue(dropdownName));
    }

    List<String> getOptionValue(String dropdownName) {
        List<String> option = new ArrayList<>();
        List<WebElement> options = driver.findElements(By.xpath(String.format("//select[@id='%s']/option", dropdownName)));
        for (WebElement opt : options) {
            option.add(opt.getText());
        }
        return option.stream().sorted().toList();
    }
}
