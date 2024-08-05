package stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AmazonPage;
import pageObjects.ListFiltersPage;
import utilities.Helper;
import utilities.LoggerUtil;
import utilities.ScreenshotUtil;


public class TestSteps {
	
	private AmazonPage AmazonPage;
	private ListFiltersPage ListFiltersPage;
	private WebDriver driver;
	private static final java.util.logging.Logger logger = LoggerUtil.getLogger(TestSteps.class);
	
	
	
	@Before
	public void setUp() {
		driver = Helper.getDriver();
		AmazonPage = new AmazonPage(driver);
		ListFiltersPage = new ListFiltersPage(driver);
	}
	
	@Given("I launch the Amazon application")
	public void I_launch_the_Amazon_application() throws Throwable {
	    Helper.openPage("https://www.amazon.co.uk/");
	    logger.info("Amazon Website is opened and maximized");
	}

    @When("I Navigate to Mobile Phones and Smartphones")
    public void I_Navigate_to_Mobile_Phones_and_Smartphones() {
    	AmazonPage.navigateToMobilePhoneAndSmartPhones();
    	logger.info("Navigated successfully to Mobile Phones and Samrtphones");
    }

	@And("I apply filters")
	public void I_apply_filters() throws InterruptedException {
		AmazonPage.filterSpecifications();
		logger.info("Filters applied successfully");
		
	        }
	
	@Then("I see the list of filter specifications")
	public void i_see_the_list_of_filter_specifications() {
		ListFiltersPage.verifyFilterSpecifications();
        logger.info("Verification completed. Samsung phones are present.");
	}
	
    @AfterStep
    public void takeScreenshotOnFailure(Scenario scenario) {
        if (scenario.isFailed()) {
         ScreenshotUtil.captureScreenshot(driver, scenario.getId().replaceAll(" ", "_"));
        }
    }
    @After
    public void tearDown() {
        Helper.quitDriver();
        logger.info("Browser closed");
    }


}
