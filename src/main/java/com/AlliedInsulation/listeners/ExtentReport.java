package com.AlliedInsulation.listeners;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.AlliedInsulation.excelUtils.ExcelUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport extends ExcelUtils {

	//We Should Declare Extent Report With Static Keyword
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports _extentReport;
	public static ExtentTest _test;
	String reportPath = System.getProperty("user.dir") + "/reports/";
	String sourceFile = reportPath + "index.html";

	@BeforeSuite
	public void reportSetup() {
		try {
			htmlReporter = new ExtentSparkReporter(sourceFile);
			htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
			htmlReporter.config().setDocumentTitle("Automation Report");
			htmlReporter.config().setTimelineEnabled(true);
			htmlReporter.config().setReportName("Allied Insulation Project Report");
			htmlReporter.config().setTheme(Theme.DARK);
			_extentReport = new ExtentReports();
			_extentReport.setSystemInfo("Automation Tester", "Murthaja");
			_extentReport.setSystemInfo("Project", "Allied Insulation Project");
			_extentReport.setSystemInfo("OS", System.getProperty("os.name"));
			_extentReport.setSystemInfo("Java Version", System.getProperty("java.version"));
			_extentReport.setSystemInfo("User", System.getProperty("user.name"));
			_extentReport.attachReporter(htmlReporter);
		} catch (Exception e) {
			Assert.fail("Exception: Unable to initialize test report : "+e.getMessage());
		}
	}

	public ExtentTest createTest(String testCase) {
	   _test = _extentReport.createTest(testCase);
	   return _test;
	}
	
	@AfterSuite
	public void endTest() throws IOException {
		try {
			_extentReport.flush();
			LocalDateTime now = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyddMM_HHmm");
			String destinationFile = reportPath + "TestReport_" + now.format(formatter) + ".html";
			FileUtils.copyFile(new File(sourceFile), new File(destinationFile));
		} catch (IOException e) {
			_test.fail("Exception while flush extent report "+e.getMessage());
			Assert.fail("Exception while flush extent report "+e.getMessage());
		}
	}
}
