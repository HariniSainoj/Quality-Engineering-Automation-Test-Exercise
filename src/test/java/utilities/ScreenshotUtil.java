package utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
	   public static void captureScreenshot(WebDriver driver, String screenshotName) {
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        try {
	            Files.copy(source.toPath(), Paths.get("screenshots", screenshotName + "png"));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
