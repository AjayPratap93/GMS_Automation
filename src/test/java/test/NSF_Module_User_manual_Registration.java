package test;

import org.testng.annotations.Test;
import PageObject.GTCC_Admin_Page;
import PageObject.NSF_Module_Admin;
import utilities.BaseClass;
import utilities.RandomeData;

public class NSF_Module_User_manual_Registration  extends BaseClass{
	
	
String Searchname=	RandomeData.TwoDigitString();
String FirstName=RandomeData.randomString();
String MiddleName=RandomeData.randomString();
String LastName=RandomeData.randomString();
String Email=RandomeData.randomString()+"@yopmail.com";

	@Test(priority=1)
	void Module_User_registration() throws InterruptedException {
	GTCC_Admin_Page page= new GTCC_Admin_Page(driver);
	page.loginNSFModuleUser();
	NSF_Module_Admin pa=new NSF_Module_Admin(driver);
	pa.TeamNomintion();
	pa.StartEntery();
	pa.manualRegistartion();
	Thread.sleep(1000);
	pa.NameSelection(FirstName, MiddleName, LastName);
	Thread.sleep(2000);
	pa.DOB_Email(Email);
	Thread.sleep(2000);
	
	}

}
