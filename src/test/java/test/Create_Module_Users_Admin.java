package test;

import utilities.RandomeData;
import org.testng.annotations.Test;

import PageObject.GTCC_Admin_Page;
import PageObject.NSF_Module_Admin;
import utilities.BaseClass;

public class Create_Module_Users_Admin extends BaseClass {

	
	@Test
	void createModule() throws InterruptedException {
		
		String imagePath="C:/Users/Ajay Pratap/Downloads/selenium.jpg";
		String name = "NSF"+RandomeData.randomString();
		String phone = RandomeData.randomPhoneNumber();
		String Email = "NSF"+RandomeData.randomString()+"@yopmail.com";
		GTCC_Admin_Page page = new GTCC_Admin_Page(driver);
		page.loginAdminNSF();
		NSF_Module_Admin user=new NSF_Module_Admin(driver);
		user.CreatModuleButton();
		user.FirtsName(name);
		user.email(Email);
		user.phonenumber(phone);
		user.Password("12345678", "12345678");
		user.uploImage(imagePath);
		user.addPermissionbutton();
		user.chooseUSerTYpe();
		user.selectState();
		user.SelectSports();
		user.selectGender();
		user.addPermissionButton();
		user.finalCreateButton();
	}
	
}
