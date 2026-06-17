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
		String name = RandomeData.randomString();
		String phone = RandomeData.randomPhoneNumber();
		String Email = RandomeData.randomString();
		GTCC_Admin_Page page = new GTCC_Admin_Page(driver);
		page.loginAdminNSF();
		NSF_Module_Admin user=new NSF_Module_Admin(driver);
		Thread.sleep(2000);
		user.OKb();
		Thread.sleep(2000);
		user.CreatModuleButton();
		Thread.sleep(2000);
		user.FirtsName(name);
		Thread.sleep(2000);;
		user.email(Email, phone);
		Thread.sleep(2000);
		user.Password("12345678", "12345678");
		Thread.sleep(2000);
		user.uploImage(imagePath);
		
	}
	
}
