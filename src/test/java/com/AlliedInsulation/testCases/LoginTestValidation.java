package com.AlliedInsulation.testCases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.AlliedInsulation.base.BaseSetup;
import com.AlliedInsulation.pages.HomePageObjects;
import com.AlliedInsulation.pages.LoginPageObjects;
import com.aventstack.extentreports.Status;

public class LoginTestValidation extends BaseSetup {
	String excelName = "LoginData";
	String sheetName;

	@Test(dataProvider = "getLoginSheetData")
	public void loginPageValidation(String email, String password) throws InterruptedException, IOException {
		try {
			launchToUrl(configProperties());
			LoginPageObjects login = new LoginPageObjects(driver);
			HomePageObjects homePage = new HomePageObjects(driver);
			login.checkLoginPageTitle("Index - AlliedInsulation.CRM");
			login.checkLoginPageURL("https://dev-alliedin-crm.azurewebsites.net/");
			login.checkLoginPage();
			login.enterUserEmail(email);
			login.enterPassword(password);
			login.clickPasswordShowHideEyeIcon();
			login.clickPasswordShowHideEyeIcon();
			login.clickLogin();
			homePage.clickLogoutMenu();
			login.checkLoginPageTitle("Index - AlliedInsulation.CRM");

		} catch (Exception e) {
			_test.log(Status.FAIL, e.getMessage());
			Assert.fail("Exception In Login Page Validation " + e.getMessage());
		}
	}

	@Test(dataProvider = "getLoginValidationsSheetData")
	public void loginValidationTestWithInvalid(String email, String password, String expected)
			throws InterruptedException, IOException {
		try {
			LoginPageObjects login = new LoginPageObjects(driver);
			login.enterUserEmail(email);
			login.enterPassword(password);
			login.clickPasswordShowHideEyeIcon();
			login.clickLogin();
			if (email.isEmpty()) {
				login.checkEmptyDataErrorMessage(expected);
			} else {
				login.checkInvalidDataErrorMessage(expected);
			}

		} catch (Exception e) {
			_test.log(Status.FAIL, e.getMessage());
			Assert.fail("Exception In Login Test Validation " + e.getMessage());
		}
	}
	
	@Test(dataProvider = "getLoginSheetData")
	public void checkResetPassword(String email, String password, String expected)
			throws InterruptedException, IOException {
		try {
			LoginPageObjects login = new LoginPageObjects(driver);
			login.enterUserEmail(email);
			login.enterPassword(password);
			login.clickPasswordShowHideEyeIcon();
			login.clickLogin();
			
		} catch (Exception e) {
			_test.log(Status.FAIL, e.getMessage());
			Assert.fail("Exception In Login Test Validation " + e.getMessage());
		}
	}

	@DataProvider
	public Object[][] getLoginValidationsSheetData() throws IOException {
		sheetName = "LoginValidations";
		return getExcelData(excelName, sheetName);
	}

	@DataProvider
	public Object[][] getLoginSheetData() throws IOException {
		sheetName = "Login";
		return getExcelData(excelName, sheetName);
	}
}
