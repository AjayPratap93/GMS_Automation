package test;

import java.io.File;


import org.testng.annotations.Test;

import PageObject.GTCC_Admin_Page;
import PageObject.NSF_Module_Admin;
import utilities.BaseClass;
import utilities.RandomeData;

@Test
public class NSF_Module_User_manual_Registration  extends BaseClass{
	
	
String Searchname=	RandomeData.TwoDigitString();
String FirstName=RandomeData.randomString();
String MiddleName=RandomeData.randomString();
String LastName=RandomeData.randomString();
String Email=RandomeData.randomString()+"@yopmail.com";
String Phone=RandomeData.randomPhoneNumber();
String Adharnumber=RandomeData.randomAadhaarNumber();
String imagePath = "\"C:\\Users\\HP\\Pictures\\Screenshots\\Testing dummy images\\nature-background-high-resolution-wallpaper-for-a-serene-and-stunning-view-free-photo.jpg\"";
@Test(priority=1)
	void Module_User_registration() throws InterruptedException {
	GTCC_Admin_Page page= new GTCC_Admin_Page(driver);
	page.loginNSFModuleUser();
	NSF_Module_Admin pa=new NSF_Module_Admin(driver);
	pa.TeamNomintion();
	pa.StartEntery();
	pa.manualRegistartion();
	pa.NameSelection(FirstName, MiddleName, LastName);
	pa.DOB_Email(Email);
	pa.Number_OTP(Phone,MiddleName);
	pa.SelectGender();
	pa.Select_City();
	pa.Bloodroup();
	pa.Pincode("212562");
	pa.Address("Khelo tech");
	pa.ResponsibleOrganization("Volleyball Federation of India");
	pa.selectIdentity();
	pa.enterIdenityNumber(Adharnumber);
	File file=new File(imagePath);
	System.out.println(file.exists());
	pa.UploadProofImage(imagePath);
	pa.ProfileImage(imagePath);
	pa.submitbutton();
	Thread.sleep(5000);

	}

}
