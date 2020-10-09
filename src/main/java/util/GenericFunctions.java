package util;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.io.FileHandler;

public class GenericFunctions {
	
	public static String screenshotFilePath="./screenshots/sample.png";
	
	public String screenshot(WebDriver driver, String testName) {
		long i=System.currentTimeMillis();
    	try {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {			
				e1.printStackTrace();
			}
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				screenshotFilePath=System.getProperty("user.dir")+"/reports/screenshots/"+testName+"_"+i+".png";				
				//BaseWebDriver.screenshotFilePath=System.getProperty("user.dir")+"/ExtentSplashBIReports/screenshots/"+testName+".png";
				FileHandler.copy(srcFile, new File(screenshotFilePath));
				screenshotFilePath="./screenshots/"+testName+"_"+i+".png";
			} catch (IOException e) {				
				e.printStackTrace();
			}
		} catch (WebDriverException e) {			
			e.printStackTrace();
		}
		return screenshotFilePath;
    }

}
