package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import PageObject.GTCC_Admin_Page;
import PageObject.NSF_Module_Admin;
import utilities.BaseClass;

public class FInal_Submit_Of_Registration extends BaseClass {
	
	
	public 	Logger logger;
	Logger  log =  LogManager.getLogger(this.getClass());
	@Test
	public void Final_Submit() throws InterruptedException { 
		GTCC_Admin_Page page= new GTCC_Admin_Page(driver);
		page.loginNSFModuleUser();  
		NSF_Module_Admin pa=new NSF_Module_Admin(driver);
		pa.viewRegistartion();
		pa.finalSubmit();
		Thread.sleep(5000);
		
	}

}
