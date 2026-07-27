package test;

import org.testng.annotations.Test;
import PageObject.GTCC_Admin_Page;
import PageObject.NSF_Module_Admin;
import utilities.BaseClass;
import utilities.RandomeData;

public class NSF_Module_User_existing_Registration  extends BaseClass{
	
	
	
String Searchname=	RandomeData.TwoDigitString();
	
	@Test(priority=1)
	void Module_User_registration() throws InterruptedException {
	GTCC_Admin_Page page= new GTCC_Admin_Page(driver);
	page.loginNSFModuleUser();
	NSF_Module_Admin pa=new NSF_Module_Admin(driver);
	pa.TeamNomintion();
	Thread.sleep(1000);
	//pa.StartEntery();
	Thread.sleep(1000);
	pa.SearchEntery();
	Thread.sleep(1000);
	}
	//@Test(priority=2)
	void manual_Registartion() {
		manual_Registartion();
		
	}

}
