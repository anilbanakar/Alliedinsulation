package com.AlliedInsulation.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormat;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.AlliedInsulation.excelUtils.ExcelUtils;
import com.AlliedInsulation.listeners.ExtentReport;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseSetup extends ExtentReport {

	public WebDriver driver;
	public String  browserName, environment, baseUrl, testCaseName;

	public String configProperties() throws IOException, InterruptedException {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("./src/test/resources/com/project/properties/config.properties"));
			String prod=prop.getProperty("production");
			if(prod.equalsIgnoreCase("true")) {
				baseUrl = prop.getProperty("prod");
			}else {
				baseUrl = prop.getProperty("dev");
			}
			browserName = prop.getProperty("browser");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return baseUrl;
	}

	public WebDriver setupWebdriver() throws IOException, InterruptedException {
		configProperties();
		try {
			switch (browserName) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
			case "ie":
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				break;
			default:
				throw new IllegalArgumentException("Invalid browser name: " + browserName);
			}
		} catch (Exception e) {
			Assert.fail("Exception: Unable to initialize web driver : " + e.getMessage());
		}
		return driver;
	}

	@BeforeTest
	public void baseSetup() throws IOException, InterruptedException {
		setupWebdriver();
	}

	public void launchToUrl(String baseURL) {
		try {
			driver.navigate().to(baseURL);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		} catch (Exception e) {
			Assert.fail("Exception in While launching the url : "+e.getMessage());
		}
	}

	@AfterTest
	public void tearDown() {
		try {
			driver.quit();
		} catch (Exception e) {
			_test.fail("Exception in While Close the browser instance: "+e.getMessage());
		}
	}
	
	@BeforeMethod
	public void startTestCase(Method method) {
		try {
			_test = createTest(method.getName());
		} catch (Exception e) {
			_test.fail("Unable to create test case "+e.getMessage());
			Assert.fail("Unable to create test case "+e.getMessage());
		}
	}

	/**
	 * Take ScreenShot As BASE64 Encoding Format Using this 'data:image/png;base64'
	 * for output screenshot format as png
	 */
	public String screenshot(WebDriver driver) {
		String screenshot = null;
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			String base64EncodedScreenshot = ts.getScreenshotAs(OutputType.BASE64);
			screenshot = "data:image/png;base64," + base64EncodedScreenshot;
		} catch (WebDriverException e) {
			e.printStackTrace();
			_test.fail("Exepection : Unable to take screenshot "+e.getMessage());
		}
		return screenshot;
	}

	public void logStatus(String desc, String status) {
		String screenshot = screenshot(driver);
		if (status.equalsIgnoreCase("PASS")) {
			_test.pass(desc, MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
		} else if (status.equalsIgnoreCase("FAIL")) {
			_test.fail(desc, MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
		} else if (status.equalsIgnoreCase("SKIP")) {
			_test.skip(desc, MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
		}
	}
}
