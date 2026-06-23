package utilites;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.google.common.io.Files;

import utilities.ConfigReader;

public class BaseClass {
	public WebDriver driver;
	public 	Logger logger;
	Logger  log =  LogManager.getLogger(this.getClass());
	@BeforeMethod
	public void SetUp() {
		log.info("===== Test Execution Started =====");
		
		ChromeOptions options = new ChromeOptions();

		// Disable password manager
		Map<String, Object> prefs = new HashMap<>();

		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);

		// Disable password breach detection
		prefs.put("profile.password_manager_leak_detection", false);

		options.setExperimentalOption("prefs", prefs);
		
		driver =new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		ConfigReader config = new ConfigReader();
		log.info("Successful browser Lounch");
		driver.get(config.getURL());	
	}
	@AfterMethod
	public void close() {
		log.info("Close Browser");
		driver.quit();
	}
	
//	public  String captueScreen(String Tname) throws IOException {
//		SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss");
//		Date de=new Date();
//		String currentDateTime = df.format(de);
//		TakesScreenshot takeScree=(TakesScreenshot) driver;
//		File sourceFile = takeScree.getScreenshotAs(OutputType.FILE);
//		String ScreenPath = System.getProperty("D:\\AutomationWorkspace\\GMS_Automation\\screenshot\\") + Tname + "_" + currentDateTime + ".png";
//		File newTarget=new File(ScreenPath);
//		FileUtils.copyDirectory(sourceFile, newTarget);
//		return ScreenPath;
//	}
	
	public String captueScreen(String testName) throws IOException {
		SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss");
		Date de=new Date();
		String currentDateTime = df.format(de);

	    String path = System.getProperty("user.dir") + "/screenshots/" + testName +"_"+currentDateTime+ ".png";

	    TakesScreenshot ts = (TakesScreenshot) driver;
	    File source = ts.getScreenshotAs(OutputType.FILE);

	    File destination = new File(path);
	    destination.getParentFile().mkdirs();

	    Files.copy(source, destination);

	    return path;
	}
}
