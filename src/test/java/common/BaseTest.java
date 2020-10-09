package common;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import util.ExtentManager;
import util.GenericFunctions;
public class BaseTest extends GenericFunctions{
	
	protected ExtentTest extentTest;
	protected WebDriver driver;
	protected WebDriverWait wait;
	 
		private static ExtentReports extentReports = ExtentManager.getInstance();
		
		public void initialization(String tcName) throws Exception {
			extentTest = getExtentTest(tcName);
			driver = getDriver();
		}
		
		public ExtentTest getExtentTest(String tcName) throws Exception {
			extentTest = null;
			return extentTest = extentReports.createTest(tcName);
		}
		
		public WebDriver getDriver() {	
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();			
			options.addArguments("--disable-extensions"); 
			options.addArguments("--disable-gpu");
			options.addArguments("--no-sandbox");
			options.addArguments("--headless");
			WebDriver driver = new ChromeDriver(options);
			return driver;
		}	
		
		@AfterClass
		public void cleanup () {
			driver.quit();
			extentReports.flush();
		}
		
		@AfterMethod
		public void afterMethod(ITestResult result) throws IOException {
			if (result.getStatus() == ITestResult.FAILURE) {			
				extentTest.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
				extentTest.fail("Package Name & Class Name: ");			
				extentTest.fail(result.getThrowable());			
				  if(driver != null) {
				  System.out.println("came to extent fail log "+screenshotFilePath);
				  extentTest.fail(screenshotFilePath, MediaEntityBuilder.createScreenCaptureFromPath(screenshotFilePath).build());
				  }
				 
			} else if (result.getStatus() == ITestResult.SKIP) {
			
				extentTest.log(Status.SKIP,MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.ORANGE));
			} else if (result.getStatus() == ITestResult.SUCCESS) {
				
				extentTest.log(Status.PASS,	MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
			}
		}
		
	} 