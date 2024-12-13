package core;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ScreenshotUtil {
    private WebDriver driver;

    public ScreenshotUtil(WebDriver driver) {
        this.driver = driver;
    }

    public byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public void saveScreenshot(String filename) {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Ensure the directory exists
            File file = new File(filename);
            file.getParentFile().mkdirs();

            // Save the screenshot
            FileHandler.copy(screenshot, file);
            System.out.println("Screenshot saved at: " + filename);

        } catch (IOException e) {
            System.err.println("Failed to save screenshot at: " + filename);
            e.printStackTrace(); // Log the stack trace for debugging
        } catch (Exception e) {
            System.err.println("An unexpected error occurred while saving the screenshot.");
            e.printStackTrace();
        }
    }
}