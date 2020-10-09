package util;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager{ 
	private static ExtentReports extentReports;
    private static String resultFileName;
    
    private ExtentManager() {}
    
    public static synchronized ExtentReports getInstance(){ 
    	if (extentReports == null) {
			createInstance();
		}
		return extentReports;
    } 
    
public static ExtentReports createInstance()  {
		
		String BaseResultFolder = System.getProperty("user.dir") + "\\reports\\reports";
		long currentTimeStamp = System.currentTimeMillis();
		resultFileName = BaseResultFolder + currentTimeStamp+".html";
		ExtentSparkReporter spark = new ExtentSparkReporter(resultFileName);
		
		System.out.println("RESULT FILE: " + resultFileName);
		spark.config().setDocumentTitle("SplashBI Automation");
		spark.config().setReportName("SplashBI Sanity");
		spark.config().setTimeStampFormat("MM/dd/yyyy HH:mm:ss");		

		extentReports = new ExtentReports();
		extentReports.attachReporter(spark);
		extentReports.setSystemInfo("OS", "windows");
		extentReports.setSystemInfo("UserName", "Govardhan");
		extentReports.setSystemInfo("Email", "Govardhan.karnati@splashbi.com");
		extentReports.setSystemInfo("Organization", "SplashBI");
		return extentReports;
	}
	
} 