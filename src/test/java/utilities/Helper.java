package utilities;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Helper {
	    public static WebDriver driver ;
	    
	    public static WebDriver getDriver() {
	    	if (driver == null) {
	        driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        }
			return driver;    
	    	
	    }    
	    
	    public static void openPage(String url) {
	        driver.get("https://www.amazon.co.uk/");
	        driver.findElement(By.id("sp-cc-accept")).click();
	        driver.manage().window().maximize();
	    }    
       
	
	     public static void quitDriver() {
	         if(driver!=null) {
	             driver.quit();
	             driver = null;
	         }

	     }
	     
}