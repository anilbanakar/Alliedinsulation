package com.AlliedInsulation.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.AlliedInsulation.base.BaseSetup;
import com.AlliedInsulation.pages.HomePageObjects;
import com.AlliedInsulation.pages.LoginPageObjects;

public class DashboardTestValidation extends BaseSetup{

	String excelSheet = "LoginData";
	String sheetName = "Login";
	
	//Check the dashboard page
	@Test(dataProvider = "getExcelData")
	public void checkDashboardPage(String email, String password ) throws InterruptedException, IOException {
		launchToUrl(configProperties());
		HomePageObjects homePage = new HomePageObjects(driver);
		LoginPageObjects loginPage = new LoginPageObjects(driver);
		loginPage.enterUserEmail(email);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		homePage.checkHomePage();	
	}
	
	@DataProvider
	public String[][] getExcelData() throws IOException {
		return getExcelData(excelSheet, sheetName);
	}
}
