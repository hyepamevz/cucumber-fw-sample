package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

    // ThreadLocal instance for WebDriver
    private static ThreadLocal<WebDriver> driver = ThreadLocal.withInitial(() -> {
        WebDriverManager.chromedriver().setup();
        // Create a new ChromeDriver instance for the current thread
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize(); // Maximize the window (optional)
        return webDriver;
    });

    // Setup method for WebDriver initialization
    public static WebDriver getDriver() {
        return driver.get();
    }

    // Quit the WebDriver
    public static void closeDriver() {
        WebDriver webDriver = driver.get(); // Get the driver for the current thread
        if (webDriver != null) {
            webDriver.quit(); // Quit the driver
            driver.remove(); // Clean up the ThreadLocal variable
        }
    }
}
