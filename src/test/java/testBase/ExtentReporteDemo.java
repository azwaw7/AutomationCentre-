package testBase;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporteDemo  {
	ExtentReports extent;

	@BeforeTest
	public void getExtentReporte() {
		String path = System.getProperty("user.dir") + "\\reporter\\index.html";
		ExtentSparkReporter reportert = new ExtentSparkReporter(path);
		reportert.config().setDocumentTitle("demoExtentAutomations");
		reportert.config().setReportName("automationCentr");
		extent = new ExtentReports();
		extent.attachReporter(reportert);
		extent.setSystemInfo("tester", "jsk");

	}

	@Test
	public void extentReportDemo() throws IOException {
		ExtentTest test = extent.createTest("demoTest");
		WebDriver driver;
		driver = new ChromeDriver();
		driver.get("https://www.browserstack.com/guide/take-screenshots-in-selenium");
		driver.getTitle();
		String paths =TakeScrennShot("extentReportDemo",driver);
		test.addScreenCaptureFromPath(paths, "extentReportDemo");
		extent.flush();

	}
	public static String TakeScrennShot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File(System.getProperty("user.dir") + "//capture//" + testCaseName + ".png");
		FileUtils.copyFile(source, destinationFile);
		return System.getProperty("user.dir") + "//capture//" + testCaseName + ".png";

	}

}
