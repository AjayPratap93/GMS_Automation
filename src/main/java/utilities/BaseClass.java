package utilities;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BaseClass {
	public WebDriver driver;
	public 	Logger logger;
	Logger  log =  LogManager.getLogger(this.getClass());
	@BeforeMethod
	public void SetUp() {
		log.info("===== Test Execution Started =====");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		ConfigReader config = new ConfigReader();
		driver.get(config.getURL());	
	}
	@AfterMethod
	public void close() {
		driver.quit();
	}
}
