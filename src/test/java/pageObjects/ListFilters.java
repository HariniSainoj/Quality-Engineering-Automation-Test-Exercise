package pageObjects;

import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListFilters {
	
	private WebDriver driver;
	private static WebDriverWait wait;
	
	  public ListFilters (WebDriver driver)
	  {
		  this.driver = driver;
		   wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	   PageFactory.initElements(driver, this);
	  }

	public static List<WebElement> listFilterSpecifications() {	
		  List<WebElement> phones = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h2/a[contains(@href, 'Samsung')]")));		  
		  for (WebElement phone : phones) {
		  String phoneName = phone.getText();
		  assertTrue("Phone is not a Samsung model: "+ phone, phoneName.contains("Samsung"));

		  
	}
		return phones;
	
	}
}
	
	
