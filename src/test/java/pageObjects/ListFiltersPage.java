package pageObjects;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ListFiltersPage {
	
	public WebDriver driver;

	
	  public ListFiltersPage (WebDriver driver)
	  {
		  this.driver = driver;
	   PageFactory.initElements(driver, this);
	  }
	  
	  @FindBy(xpath = "//div[@data-component-type='s-search-result' and contains(@data-cel-widget,'search_result')]//div[@data-cy='title-recipe']//span")
	   public List<WebElement> phoneList;

	public void verifyFilterSpecifications() {	  
		  for (WebElement phone : phoneList) {
		  String phoneName = phone.getText();
		  assertTrue("Phone is not a Samsung model: "+ phoneName, phoneName.contains("Samsung"));
		  System.out.println(phoneName);
		  
	}

	
	}
}
	
	
