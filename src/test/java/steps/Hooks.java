package steps;

import core.ScreenshotUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import core.BaseTest;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.Scenario;

public class Hooks extends BaseTest {
    private WebDriver driver;

    @Before
    public void setup() {
        this.driver = getDriver();
    }

    @After
    public void teardown(Scenario scenario) {
        // Check if the scenario failed
        if (scenario.isFailed()) {
            ScreenshotUtil screenshotUtil = new ScreenshotUtil(this.driver);
            // Take a screenshot and attach it to the Cucumber report
            byte[] screenshotBytes = screenshotUtil.takeScreenshot();
            scenario.attach(screenshotBytes, "image/png", "Failure Screenshot");

            // Save the screenshot to a file
            String filename = "target/screenshots/" + scenario.getName().replaceAll("[^a-zA-Z0-9]", "_") + ".png";
            screenshotUtil.saveScreenshot(filename);
        }
        closeDriver();
    }
}