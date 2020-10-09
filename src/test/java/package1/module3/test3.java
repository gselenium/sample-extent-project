package package1.module3;


import org.testng.annotations.Test;


import common.BaseTest;
import pages.LoginPage;

public class test3 extends BaseTest
{ 
	LoginPage loginPage=null;
    
    @Test
    public void f() throws Exception {
    	initialization(this.getClass().getName());
    	extentTest.pass("staring is the pack1 module3 third test case");
    	loginPage=new LoginPage(driver, wait, extentTest);
    	loginPage.navigateToURL();
    	loginPage.enterSearchbox("pack1 moduel3 third");
    	extentTest.pass("ending is the pack1 module 3 third test case");
    }
	
} 