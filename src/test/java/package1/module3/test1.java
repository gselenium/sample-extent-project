package package1.module3;


import org.testng.annotations.Test;


import common.BaseTest;
import pages.LoginPage;

public class test1 extends BaseTest
{ 
	LoginPage loginPage=null;
    
    @Test
    public void f() throws Exception {
    	initialization(this.getClass().getName());
    	extentTest.pass("staring is the pack1 module 3 first test case");
    	loginPage=new LoginPage(driver, wait, extentTest);
    	loginPage.navigateToURL();
    	loginPage.enterSearchbox("pack1 moduel3 first");    	
    	extentTest.pass("ending is the pack1 module 3 first test case");
    }
	
} 