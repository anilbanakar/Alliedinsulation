package com.AlliedInsulation.commonUtilities;

import java.time.Duration;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidOperationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

	public static WebElement ele;
	public static List<WebElement> elements;
	public static WebDriverWait wait;
	public static int WAIT_TIMEOUT = 10;

	public static WebElement waitForElementToBeVisible(WebDriver driver, By element) {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT));
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ele;
	}

	public static WebElement waitForElementToBeClickable(WebDriver driver, By element) {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT));
			ele = wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			throw new InvalidOperationException("Exception "+e.getMessage());
		}
		return ele;
	}
	
	public static  List<WebElement> waitForVisibilityOfAllElementsLocated(WebDriver driver, By element) {
		try {
			elements =new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT))
			.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));	
		} catch (Exception e) {
			throw new InvalidOperationException("Exception "+e.getMessage());
		}
		return elements;
	}
}
