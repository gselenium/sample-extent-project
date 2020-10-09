package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentTest;

import util.GenericFunctions;

public class BasePage extends GenericFunctions {
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected ExtentTest extentTest;

	public BasePage(WebDriver driver, WebDriverWait wait, ExtentTest extentTest) {
		this.driver = driver;
		this.wait = wait;
		this.extentTest = extentTest;
		PageFactory.initElements(driver, this);
	}

}
