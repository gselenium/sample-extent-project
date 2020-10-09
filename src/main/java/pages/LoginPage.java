package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver, WebDriverWait wait, ExtentTest extentTest) {
		super(driver, wait, extentTest);
	}

	//private By searchBox=By.name("q");
		@FindBy(xpath="//*[@name='q']")WebElement searchBox;
		@FindBy(xpath="testing")WebElement gmaillink;	
		public void enterSearchbox(String text) {
			searchBox.sendKeys(text);		
			extentTest.pass("entered value into search box field");
		}
		
		public void clickGmailLink() {
			try {
				gmaillink.click();
				extentTest.pass("Clicked on Gmail link");
			} catch (Exception e) {
				extentTest.fail("Unable to click on Gmail link");
				screenshot(driver, "clickGmailLink");
				Assert.fail();
			}
			
		}
		
		public void navigateToURL() {			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("https://www.google.co.in");
			extentTest.pass("navigate to google homepage");
		}
		
	} 