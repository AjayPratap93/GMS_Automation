package test;

import org.testng.annotations.Test;

import PageObject.GTCC_Admin_Page;
import PageObject.NSF_Module_Admin;
import utilites.BaseClass;
import utilities.RandomeData;

public class NSF_Module_User_Start_Registration  extends BaseClass{
	
	
	
String Searchname=	RandomeData.TwoDigitString();
	
	@Test
	void Module_User_registration() throws InterruptedException {
	GTCC_Admin_Page page= new GTCC_Admin_Page(driver);
	page.loginNSFModuleUser();
	NSF_Module_Admin pa=new NSF_Module_Admin(driver);
	pa.TeamNomintion();
	Thread.sleep(3000);
	pa.StartEntery();
	Thread.sleep(3000);
	pa.SearchEntery("an");
	Thread.sleep(3000);
	}

}
