package com.AlliedInsulation.commonUtilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.AlliedInsulation.base.BaseSetup;
import com.aventstack.extentreports.MediaEntityBuilder;

public class Validation extends BaseSetup {

	public void validatePageTitle(WebDriver driver, String expectedTitle, String stepDesc) {
		try {
			System.out.println("Title: " + driver.getTitle());
			Assert.assertEquals(driver.getTitle(), expectedTitle);
			_test.pass("Passed :" + stepDesc,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot(driver)).build());
		} catch (AssertionError e) {
			_test.fail("Failed : " + stepDesc + " " + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot(driver)).build());
			throw new AssertionError("Unable To Click the element " + e.getMessage());
		}
	}

	public void validatePageUrl(WebDriver driver, String expectedURL, String stepDesc) {
		try {
			System.out.println("Title: " + driver.getCurrentUrl());
			Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
			_test.pass("Passed :" + stepDesc,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot(driver)).build());
		} catch (AssertionError e) {
			_test.fail("Failed :" + stepDesc + " " + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot(driver)).build());
			throw new AssertionError("Unable To Click the element " + e.getMessage());
		}
	}

	public void validateText(WebDriver driver, By element, String expectedValue, String stepDesc) {
		try {
			WebElement ele = WaitUtils.waitForElementToBeVisible(driver, element);
			Assert.assertEquals(ele.getText(), expectedValue);
			_test.pass("Passed :" + stepDesc,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot(driver)).build());
		} catch (AssertionError e) {
			_test.fail("Failed :" + stepDesc + " " + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot(driver)).build());
			throw new AssertionError("Unable To Click the element " + e.getMessage());
		}
	}

	public void validateElementIsExists(WebDriver driver, By element, String stepDesc) {
		try {
			WebElement ele = WaitUtils.waitForElementToBeVisible(driver, element);
			Assert.assertNotNull(ele);
			_test.pass("Passed :" + stepDesc,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot(driver)).build());
		} catch (AssertionError e) {
			_test.fail("Failed :" + stepDesc + " " + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot(driver)).build());
			throw new AssertionError("Unable To Click the element " + e.getMessage());
		}
	}

	public void validateElementIsNotPresented(WebDriver driver, By element, String stepDesc) {
		try {
			WebElement ele = WaitUtils.waitForElementToBeVisible(driver, element);
			Assert.assertTrue(!ele.isDisplayed());
			_test.pass("Passed :" + stepDesc,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot(driver)).build());
		} catch (AssertionError e) {
			_test.fail("Failed :" + stepDesc + " " + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot(driver)).build());
			throw new AssertionError("Unable To Click the element " + e.getMessage());
		}
	}
}
