package com.AlliedInsulation.commonUtilities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.openxml4j.exceptions.InvalidOperationException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.AlliedInsulation.base.BaseSetup;
import com.aventstack.extentreports.MediaEntityBuilder;

public class CommonMethods extends BaseSetup {

	String elementText;
	public void commonLogReport(WebDriver driver, boolean value, String stepDesc) {
		if (value = true) {
			_test.pass("Passed :" + stepDesc,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot(driver)).build());
		} else {
			_test.pass("Failed :" + stepDesc,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot(driver)).build());
		}
	}

	public void clickElement(WebDriver driver, By element, String stepDesc) {
		try {
			WaitUtils.waitForElementToBeClickable(driver, element).click();
			_test.pass("Passed :" + stepDesc,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot(driver)).build());
		} catch (Exception e) {
			_test.fail("Failed :" + stepDesc + " " + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot(driver)).build());
			throw new AssertionError("Unable To Click the element "+e.getMessage());
		}
	}

	public void clickElementByIndex(WebDriver driver, By element, int indexValue, String stepDesc) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
			List<WebElement> ele = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
			for (int i = 0; i < ele.size(); i++) {
				ele.get(indexValue).click();
			}
			_test.pass("Passed :" + stepDesc,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot(driver)).build());
		} catch (Exception e) {
			_test.fail("Failed :" + stepDesc + " " + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot(driver)).build());
			e.printStackTrace();
			throw new AssertionError("Unable To Click the element "+e.getMessage());
		}
	}

	public void clickElementByMatchingText(WebDriver driver, By element, String expectedValue, String stepDesc) {
		try {
			List<WebElement> ele = WaitUtils.waitForVisibilityOfAllElementsLocated(driver, element);
			for (WebElement webElement : ele) {
				if (webElement.getText().equals(expectedValue)) {
					webElement.click();
					_test.pass("Passed :" + stepDesc,
							MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot(driver)).build());
					break;
				}
			}
		} catch (Exception e) {
			_test.fail("Failed :" + stepDesc + " " + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot(driver)).build());
			throw new AssertionError("Unable To Click the element "+e.getMessage());
		}
	}

	public void enterValue(WebDriver driver, By element, String value, String stepDesc) {
		try {
			WebElement ele = WaitUtils.waitForElementToBeVisible(driver, element);
			ele.clear();
			ele.sendKeys(value);
			_test.pass("Passed :" + stepDesc,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot(driver)).build());
		} catch (Exception e) {
			_test.fail("Failed :" + stepDesc + " " + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot(driver)).build());
			throw new AssertionError("Unable To Click the element "+e.getMessage());
		}
	}

	public void enterValueByKey(WebDriver driver, By element, String value, String stepDesc) {
		try {
			WebElement ele = WaitUtils.waitForElementToBeVisible(driver, element);
			ele.click();
			ele.sendKeys(Keys.CONTROL + "a");
			ele.sendKeys(Keys.BACK_SPACE);
			ele.sendKeys(value);
			_test.pass("Passed :" + stepDesc,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot(driver)).build());
		} catch (Exception e) {
			_test.fail("Failed :" + stepDesc + " " + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot(driver)).build());
			throw new AssertionError("Unable To Click the element "+e.getMessage());
		}
	}

	// Handle Dropdown By Using Select Class
	public void selectByIndexFromDropDown(WebDriver driver, By element, int index, String stepDesc) {
		try {
			Select select = new Select(driver.findElement(element));
			select.selectByIndex(index);
			_test.pass("Passed :" + stepDesc,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot(driver)).build());
		} catch (Exception e) {
			_test.fail("Failed :" + stepDesc + " " + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot(driver)).build());
			throw new AssertionError("Unable To Click the element "+e.getMessage());
		}
	}

	public void selectByVisibleTextFromDropDown(WebDriver driver, By element, String visibleText, String stepDesc) {
		try {
			Select select = new Select(driver.findElement(element));
			select.selectByVisibleText(visibleText);
			_test.pass("Passed :" + stepDesc,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot(driver)).build());
		} catch (Exception e) {
			_test.fail("Failed :" + stepDesc + " " + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot(driver)).build());
			throw new AssertionError("Unable To Click the element "+e.getMessage());
		}
	}

	public void selectByValueFromDropDown(WebDriver driver, By element, String value, String stepDesc) {
		try {
			Select select = new Select(driver.findElement(element));
			select.selectByValue(value);
			_test.pass("Passed :" + stepDesc,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot(driver)).build());
		} catch (Exception e) {
			_test.fail("Failed :" + stepDesc + " " + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot(driver)).build());
			throw new AssertionError("Unable To Click the element "+e.getMessage());
		}
	}

	public String checkDefaultSelectedValueInDropDown(WebDriver driver, By element, String value, String stepDesc) {
		String defaultSelectedOption = "";
		try {
			Select select = new Select(driver.findElement(element));
			defaultSelectedOption = select.getFirstSelectedOption().getText();
			if (defaultSelectedOption.equals(value)) {
				commonLogReport(driver, true, stepDesc);
			} else {
				commonLogReport(driver, false, stepDesc);
			}
		} catch (Exception e) {
			_test.fail("Failed :" + stepDesc + " " + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot(driver)).build());
			throw new AssertionError("Unable To Click the element "+e.getMessage());
		}
		return defaultSelectedOption;
	}

	public void checkTextInDropDown(WebDriver driver, By element, String textValue, String stepDesc) {
		boolean value = false;
		try {
			Select select = new Select(driver.findElement(element));
			List<WebElement> options = select.getOptions();
			for (WebElement option : options) {
				if (option.getText().equals(textValue)) {
					commonLogReport(driver, true, stepDesc);
					value = true;
					break;
				}
			}
			if (value) {
				commonLogReport(driver, true, stepDesc);
			} else {
				commonLogReport(driver, false, stepDesc);
			}
		} catch (Exception e) {
			_test.fail("Failed :" + stepDesc + " " + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot(driver)).build());
			throw new AssertionError("Unable To Click the element "+e.getMessage());
		}
	}

	// Handle Alerts Interface class By Using Action Class
	public boolean isAlertPresented(WebDriver driver) {
		try {
			driver.switchTo().alert();
			commonLogReport(driver, true, "Alert Is Presented");
			return true;
		} catch (NoAlertPresentException e) {
			commonLogReport(driver, false, "Alert Is Presented");
			return false;
		}
	}

	public String alertAction(WebDriver driver, String action) {
		if (isAlertPresented(driver)) {
			Alert alert = driver.switchTo().alert();
			if (action.equalsIgnoreCase("accept")) {
				alert.accept();
				commonLogReport(driver, true, "Alert Accepted");
			} else if (action.equalsIgnoreCase("dismiss")) {
				alert.dismiss();
				commonLogReport(driver, true, " Alert Dismissed");
			} else {
				commonLogReport(driver, true, " Get Alert Text");
				return alert.getText();
			}
		} else {
			commonLogReport(driver, false, "No Alert Presented");
		}
		return null;
	}

	public String getElementText(WebDriver driver, By element, String stepDesc) {
		try {
			elementText = WaitUtils.waitForElementToBeVisible(driver, element).getText();
			_test.pass("Passed :" + stepDesc,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot(driver)).build());
		} catch (Exception e) {
			_test.fail("Failed :" + stepDesc + " " + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot(driver)).build());
			throw new InvalidOperationException("Unable To Click the element "+e.getMessage());
		}
		return elementText;
	}

	public String getAttributeValue(WebDriver driver, By element, String elementName, String stepDesc) {
		try {
			elementText = WaitUtils.waitForElementToBeVisible(driver, element).getAttribute(elementName);
			_test.pass("Passed :" + stepDesc,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot(driver)).build());
		} catch (Exception e) {
			_test.fail("Failed :" + stepDesc + " " + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot(driver)).build());
			throw new InvalidOperationException("Unable To Click the element "+e.getMessage());
		}
		return elementText;
	}
	
	public  void switchTowindow() {
		try {
			Set<String> windows = driver.getWindowHandles();
			driver.switchTo().window(elementText);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}