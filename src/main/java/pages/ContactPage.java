package pages;

import com.github.javafaker.Faker;
import core.BasePage;
import core.BaseTest;
import core.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends BasePage {

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    //Locator
    @FindBy(xpath = "//input[@type='submit']")
    private static WebElement submitButton;
    @FindBy(name = "message")
    private static WebElement commentTxtArea;
    @FindBy(xpath = "//h1[text()='Thank You for your Message!']")
    private static WebElement thankYouMessage;

    public void submitContact() {
        Faker faker = new Faker();

        enterField("first_name", faker.name().firstName());
        enterField("last_name", faker.name().lastName());
        enterField("email", faker.internet().emailAddress());

        addComment(ConfigReader.getSampleText());
        clickSubmitButton();
        this.waitForPageLoad();
    }

    public void addComment(String comment) {
        this.waitUntilVisibilityOf(commentTxtArea).sendKeys(comment);
    }

    public void clickSubmitButton() {
        this.waitUntilVisibilityOf(submitButton).click();
    }

    void enterField(String field, String value) {
        String fieldLocator = "//input[@name='%s']";
        driver.findElement(By.xpath(String.format(fieldLocator, field))).sendKeys(value);
    }

    public boolean isThankYouMessageDisplayed() {
        return thankYouMessage.isDisplayed();
    }
}
