package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;		
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class AmazonPage {
	  

	private WebDriver driver;
	private WebDriverWait wait;


	  public AmazonPage (WebDriver driver)
	  {
	   this.driver = driver;
	   wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	   PageFactory.initElements(driver, this);
	  }
	  
	  public void OpenPage() {
	        driver.get("https://www.amazon.co.uk/");
	    }
	  
	  @FindBy(xpath="//*[@id='nav-hamburger-menu']")
	public WebElement all;
	  
	  @FindBy(xpath="//div[text()='Electronics & Computers']")
	public WebElement electronicsAndComputers;
	  
	  @FindBy(xpath="//a[text()='Phones & Accessories']")
	 public WebElement phonesAndAccessories;
	  
	  @FindBy(xpath="//a[text()='Mobile Phones & Smartphones']")
	 public WebElement mobilePhonesAndSmartphones;
	  
	  @FindBy(xpath ="//span[contains(text(),'Brands')]/ancestor::div/following-sibling::ul//span[contains(text(),'Samsung')]/preceding-sibling::div//input[@type='checkbox']")
	  public WebElement samsungBrand;
	  
	  @FindBy(xpath ="//span[@class='a-size-base a-color-base' and text()='£50 to £100']/parent::a")
	 public WebElement price;
	  
	  @FindBy(xpath ="//span[contains(text(),'Model Year')]/ancestor::div//following-sibling::ul//span[contains(text(), '2023')]/preceding-sibling::div//input[@type='checkbox']")
	  public WebElement modelYear;
	  
	  @FindBy(xpath ="//span[contains(text(),'Camera Resolution')]/ancestor::div//following-sibling::ul//span[contains(text(), '20 MP & above')]/preceding-sibling::div//input[@type='checkbox']")  
	 public WebElement cameraResolution;
	 
	   
	   public void navigateToMobilePhoneAndSmartPhones() {
		  all.click();
		  scrollToElement(electronicsAndComputers);
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("arguments[0].click();", phonesAndAccessories);
		  wait.until(ExpectedConditions.elementToBeClickable(mobilePhonesAndSmartphones));
		  mobilePhonesAndSmartphones.click();
	  }
	   
	   public void filterSpecifications() throws InterruptedException {
		   
		   JavascriptExecutor js = (JavascriptExecutor) driver;
	   		
	   			js.executeScript("arguments[0].click();", price);
	   					waitForPageToLoad();
	   					Thread.sleep(7000);
		   
		        js.executeScript("arguments[0].click();", samsungBrand);
		   		   		 waitForPageToLoad();
		   		   		 Thread.sleep(7000);
		   			   		
		   	    js.executeScript("arguments[0].click();", modelYear);
						   waitForPageToLoad();
						   Thread.sleep(7000);
						   
		   		js.executeScript("arguments[0].click();", cameraResolution);
		   				waitForPageToLoad();
		   				Thread.sleep(7000);
	          } 	  
	   
		   private void scrollToElement(WebElement element) {
			   JavascriptExecutor js = (JavascriptExecutor) driver;
			   js.executeScript("arguments[0].scrollIntoView(true);", element);
			   wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		       wait.until(ExpectedConditions.elementToBeClickable(element));
		       element.click();
			} 
		   
		   private void waitForPageToLoad() {        
			   wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".s-main-slot")));
		    }
		   
		   
}  
		   
