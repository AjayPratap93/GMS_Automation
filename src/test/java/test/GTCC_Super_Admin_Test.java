package test;

import org.testng.annotations.Test;

import PageObject.GTCC_Admin_Page;
import utilites.BaseClass;

public class GTCC_Super_Admin_Test extends BaseClass {
	@Test
	void login() throws InterruptedException {
		GTCC_Admin_Page page = new GTCC_Admin_Page(driver);
		page.loginAdmin();
	}
}
