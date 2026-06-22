package utilites;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utilities.RandomeData;

public class ExtentReportManager implements ITestListener {
	public ExtentSparkReporter sparkReporter;// UI of report
	public ExtentReports extent;
	public ExtentTest test;
	String reportName;
	String name = RandomeData.randomString();

	public void onStart(ITestContext context) {

		SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss");
		Date de = new Date();
		String currentDateTime = df.format(de);
		reportName = name + currentDateTime + ".html";

		System.out.println("Listenere has been started ");
		sparkReporter = new ExtentSparkReporter("D:\\AutomationWorkspace\\GMS_Automation\\reports" + reportName);
		sparkReporter.config().setDocumentTitle(" Automation Report ");
		sparkReporter.config().setReportName(" Functional testing ");
		sparkReporter.config().setTheme(Theme.DARK);
		extent = new ExtentReports();

		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("computer name", "Dell ");
		extent.setSystemInfo("Environment ", "staging");
		extent.setSystemInfo(" Tester name ", "Ajay ");
		extent.setSystemInfo("OS", " Window ");
		extent.setSystemInfo("Browser ", "Chrome  ");
	}

	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Test case is passed: " + result.getName() + " Got successFully Excuted ");
	}

	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.log(Status.FAIL, " Test case is  Failed : " + result.getName());
		test.log(Status.FAIL, " Test case failed case is : " + result.getThrowable());

		try {

			Object testClass = result.getInstance();
			BaseClass base = (BaseClass) testClass;

			String imgpath = base.captueScreen(result.getName());
			test.addScreenCaptureFromPath(imgpath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, " Test case is Skiped  : " + result.getName());
	}

	public void onFinish(ITestContext context) {
		System.out.println(" Listeners has ended ");

		extent.flush();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String pathOfExtentrepo = System.getProperty("user.dir") + "\\reports\\" + reportName;
		File extentrepo = new File(pathOfExtentrepo);
		try {
			// Desktop.getDesktop().browse(extentrepo.toURI());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
