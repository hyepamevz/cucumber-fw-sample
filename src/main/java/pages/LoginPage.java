package pages;

import core.BasePage;
import core.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Objects;

public class LoginPage extends BasePage {

    // Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    @FindBy(id = "text") private WebElement usernameField;
    @FindBy(id = "password") private WebElement passwordField;
    @FindBy(id = "login-button") private WebElement loginButton;

    // Page-specific actions
    public void login(String username, String password) {
        usernameField.click();
        usernameField.sendKeys(username);
        passwordField.click();
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public boolean verifyWarningAlertExist() {
        Alert alert = driver.switchTo().alert();
        System.out.printf(alert.getText());
        return Objects.equals(alert.getText(), "validation failed");
    }
}