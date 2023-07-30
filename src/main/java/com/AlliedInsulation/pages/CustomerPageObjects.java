package com.AlliedInsulation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.AlliedInsulation.commonUtilities.CommonMethods;
import com.AlliedInsulation.commonUtilities.Validation;

public class CustomerPageObjects {

	public WebDriver driver;
	CommonMethods common = new CommonMethods();
	Validation validation = new Validation();

	public CustomerPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	// Customer Page Web Elements
	private By create = By.id("show-customer-modal");
	private By searchInput = By.xpath("//div[@id='customer-table_filter']//following-sibling::input");
	private By searchLabel = By.xpath("//div[@id='customer-table_filter']//child::label");
	private By searchButton = By.xpath("//div[@id='customer-table_filter']//child::button[1]");
	private By clearButton = By.xpath("//div[@id='customer-table_filter']//child::button[2]");

	// Create Customer Window Web Elements
	private By createCustomerWinHeader = By.tagName("h4");
	private By closeXCreateCustWin = By.xpath("//h4//following-sibling::button");
	private By name = By.id("Name");
	private By nameLabel = By.xpath("//label[text()='Name']");
	private By status = By.xpath("//select[@name='Status']");
	private By statusLabel = By.xpath("//label[text()='Status']");
	private By accType = By.name("AccountType");
	private By accountTypeLabel = By.xpath("//label[text()='AccountType']");
	private By fax = By.id("Fax");
	private By faxLabel = By.xpath("//label[text()='Fax']");
	private By email = By.id("Email");
	private By emailLabel = By.xpath("//label[text()='Email']");
	private By phone = By.id("Phone");
	private By phoneLabel = By.xpath("//label[text()='Phone']");
	private By discount = By.id("Discount");
	private By discountLabel = By.xpath("//label[text()='Discount']");
	private By markUp = By.id("MarkUp");
	private By markUpLabel = By.xpath("//label[text()='Mark Up']");
	private By createButton = By.id("create-customer");
	private By closeButton = By.xpath("//button[text()='Close']");

	private By showEntires = By.xpath("//div[@id='customer-table_length']//child::label");
	private By showEntriesDropDown = By.name("customer-table_length");

	public void checkCustomerCreatePage(String url) {
		validation.validatePageUrl(driver, url, "Check Customer Page URL");
		validation.validateElementIsExists(driver, searchLabel, "Check Search Label On Customer Page");
		validation.validateElementIsExists(driver, searchInput, "Check Search Input On Customer Page");
		validation.validateElementIsExists(driver, searchButton, "Check Search Button On Customer Page");
		validation.validateElementIsExists(driver, clearButton, "Check Clear Button On Customer Page");
		validation.validateElementIsExists(driver, create, "Check Create Button On Customer Page");
	}

	// Create Customer
	public void clickCreateCustomer() {
		common.clickElement(driver, create, "Click On Create New Customer Button ");
	}

	// Create Customer Window
	public void checkCreateNewCustomerWindow() {
		validation.validateElementIsExists(driver, createCustomerWinHeader, "Check Create New Customer Window Header");
		validation.validateElementIsExists(driver, nameLabel, "Check Name Label On Create New Customer Window");
		validation.validateElementIsExists(driver, statusLabel, "Check Status Label On Create New Customer Window");
		validation.validateElementIsExists(driver, accountTypeLabel,
				"Check Account Type Label On Create New Customer Window");
		validation.validateElementIsExists(driver, faxLabel, "Check Fax Label On Create New Customer Window");
		validation.validateElementIsExists(driver, emailLabel, "Check Email Label On Create New Customer Window");
		validation.validateElementIsExists(driver, phoneLabel, "Check Phone Label On Create New Customer Window");
		validation.validateElementIsExists(driver, discountLabel, "Check Discount Label On Create New Customer Window");
		validation.validateElementIsExists(driver, markUpLabel, "Check Mark Up Label On Create New Customer Window");
		validation.validateElementIsExists(driver, createButton, "Check Create Button On Create New Customer Window");
		validation.validateElementIsExists(driver, closeButton, "Check Close Button On Create New Customer Window");
		validation.validateElementIsExists(driver, closeXCreateCustWin,
				"Check Close X Button On Create New Customer Window");
	}
	
	public void clickOnCreateCustomer() {
		common.clickElement(driver, createButton, "Click On Create	 Button");
	}

	public void enterCustomerName(String customerName) {
		common.enterValue(driver, name, customerName, "Enter Customer Name On Name Field");
	}

	public void enterCustomerFax(String faxValue) {
		common.enterValue(driver, fax, faxValue, "Enter Fax Value On Fax Field");
	}

	public void enterCustomerEmail(String customerEmail) {
		common.enterValue(driver, email, customerEmail, "Enter Customer Email On Email Field");
	}

	public void enterCustomerPhone(String customerPhone) {
		common.enterValue(driver, phone, customerPhone, "Enter Customer Phone On Phone Field");
	}

	public void enterCustomerDiscount(String customerDiscount) {
		common.enterValue(driver, discount, customerDiscount, "Enter Customer Discount On Discount Field");
	}

	public void enterCustomerMarkUp(String customerMarkup) {
		common.enterValue(driver, markUp, customerMarkup, "Enter Customer MarkUp On MarkUp Field");
	}

	public void selectCustomerStatus(String customerStatus) throws InterruptedException {
		common.selectByVisibleTextFromDropDown(driver, status, customerStatus, "Select Customer Status");
		Thread.sleep(3000);
		common.checkDefaultSelectedValueInDropDown(driver, status, customerStatus, "Check Customer Status Is Selected");
	}

	public void selectAccountType(String customerAccType) throws InterruptedException {
		common.selectByVisibleTextFromDropDown(driver, accType, customerAccType, "Select Customer Account Type");
		Thread.sleep(3000);
		common.checkDefaultSelectedValueInDropDown(driver, accType, customerAccType, "Check Customer Account Type Is Selected");
	}

	public void clickCloseXOnCreateCustomerWin() {
		common.clickElement(driver, closeXCreateCustWin, "Click Close X Button");
	}

	public void clickCloseOptionOnCreateCustomerWin() {
		common.clickElement(driver, closeButton, "Click On Close Button");
	}

	public void clickCreateOnCreateCustomerWin() {
		common.clickElement(driver, createButton, "Click On Create	 Button");
	}

	// Create/Update Customer
	public void createOrUpdateCustomer(String custName, String custStatus, String custAccType, String custFax,
			String custEmail, String custPhone, String custDiscount, String custMarkUp) throws InterruptedException {
		enterCustomerName(custName);
		selectCustomerStatus(custStatus);
		selectAccountType(custAccType);
		enterCustomerFax(custFax);
		enterCustomerEmail(custEmail);
		enterCustomerPhone(custPhone);
		enterCustomerDiscount(custDiscount);
		enterCustomerMarkUp(custMarkUp);
	}
}
