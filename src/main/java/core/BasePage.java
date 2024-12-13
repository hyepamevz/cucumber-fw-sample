package core;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    // Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60)); // default wait of 60 seconds
    }

    // Custom function to wait until the visibility of an element
    public WebElement waitUntilVisibilityOf(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Custom function to wait until the invisibility of an element
    public boolean waitUntilInVisibilityOf(WebElement element) {
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }

    // Method to wait for the page to load completely
    public void waitForPageLoad() {
        // Initial wait of 1000 milliseconds (1 second)
        try {
            Thread.sleep(1000); // Wait for 1 seconds
        } catch (InterruptedException e) {
            e.printStackTrace(); // Handle the exception
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Wait until the readyState is 'complete'
        while (!js.executeScript("return document.readyState").equals("complete")) {
            try {
                Thread.sleep(100); // Sleep for a short time before checking again
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Initial wait of 1000 milliseconds (1 second)
        try {
            Thread.sleep(1000); // Wait for 1 seconds
        } catch (InterruptedException e) {
            e.printStackTrace(); // Handle the exception
        }
    }

    // Navigate to a specific URL
    public void navigateTo(String url) {
        driver.get(url);
        waitForPageLoad();
    }

    // Get the title of the page
    public String getPageTitle() {
        return driver.getTitle();
    }
}