package package1.module1;
import org.testng.annotations.Test;


import common.BaseTest;
import pages.LoginPage;

public class test2 extends BaseTest{ 
	LoginPage loginPage=null;
    
    @Test
    public void f() throws Exception {
    	initialization(this.getClass().getName());
    	extentTest.pass("staring is the pack1 module 1 second test case");
    	loginPage=new LoginPage(driver, wait, extentTest);
    	loginPage.navigateToURL();
    	loginPage.enterSearchbox("pack1 moduel1 second");
    	extentTest.pass("ending is the pack1 module 1 second test case");
    }
	
} 