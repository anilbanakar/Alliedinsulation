package com.AlliedInsulation.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.AlliedInsulation.base.BaseSetup;
import com.AlliedInsulation.commonUtilities.HelperUtils;
import com.AlliedInsulation.excelUtils.ExcelUtils;
import com.AlliedInsulation.pages.CustomerPageObjects;
import com.AlliedInsulation.pages.HomePageObjects;
import com.AlliedInsulation.pages.LoginPageObjects;

public class CreateCustomerTest extends BaseSetup {

	String excelSheet = "LoginData";
	String sheetName = "Login";
	String customerName, customerStatus, customerAccType, customerFax, customerEmail, customerPhone, customerDiscount,
			customerMarkUp;

	@Test(dataProvider = "getExcelData")
	public void createCustomer(String email, String password) throws IOException, InterruptedException {
		HelperUtils helper = new HelperUtils();
		customerName = "Auto_" + helper.generateRandomName();
		customerFax = helper.generateRandomFax();
		customerEmail = "Auto_" + helper.generateRandomEmail();
		customerPhone = helper.generateRandomPhone();

		launchToUrl(configProperties());
		LoginPageObjects loginPage = new LoginPageObjects(driver);
		CustomerPageObjects custPage = new CustomerPageObjects(driver);
		HomePageObjects homePage = new HomePageObjects(driver);
		loginPage.enterUserEmail(email);
		loginPage.enterPassword(password);
		loginPage.clickLogin();

		homePage.clickCustomersMenu();
		custPage.checkCustomerCreatePage("https://dev-alliedin-crm.azurewebsites.net/Customer");
		custPage.clickCreateCustomer();
		custPage.checkCreateNewCustomerWindow();
		custPage.clickCloseXOnCreateCustomerWin();
		custPage.clickCreateCustomer();
		custPage.clickCloseOptionOnCreateCustomerWin();
		custPage.clickCreateCustomer();
		custPage.createOrUpdateCustomer(customerName, "Opportunity", "Residential", customerFax, customerEmail,
				customerPhone, "1.0", "1.0");
		custPage.clickCreateOnCreateCustomerWin();
		Thread.sleep(5000);
	}

	@DataProvider
	public String[][] getExcelData() throws IOException {
		return new ExcelUtils().getExcelData(excelSheet, sheetName);
	}
}
