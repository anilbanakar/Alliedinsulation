package com.AlliedInsulation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.AlliedInsulation.commonUtilities.CommonMethods;
import com.AlliedInsulation.commonUtilities.Validation;

public class HomePageObjects {
	
	public WebDriver driver;
	CommonMethods common = new CommonMethods();
	Validation validation = new Validation();
	
	public HomePageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	//Home Page Webelements
	//Home Page Menu Tabs
	private By dashboard = By.xpath("//a[text()='Dashboard']");
	private By leads = By.xpath("//a[text()='Leads']");
	private By customers = By.xpath("//a[text()='Customers']");
	private By opportunities = By.xpath("//a[text()='Opportunities']");
	private By workOrders = By.xpath("//a[text()='Work Orders']");
	private By calendar = By.xpath("//a[text()='Calendar']");
	private By admin = By.xpath("//a[text()='Admin']");
	private By hello = By.xpath("//a[contains(text(),'Hello')]");
	private By logout = By.id("logout");
	
	
	//DashBoard 
	private By companySalesReportsHeader = By.xpath("//h2[text()='Company Sales Reports']");
	private By salesReportChart = By.id("companySalesReport");
	private By companyPipelineReportsHeader = By.xpath("//h2[text()='Company Pipeline Reports']");
	private By pipelineReportChart= By.id("companyPiplineReport");
	private By salesbySalespersonHeader = By.xpath("//h2[text()='Sales by Salesperson']");
	private By salesPersonReportChart = By.id("salesPersonSalesReport");
	private By pipelinebySalespersonHeader = By.xpath("//h2[text()='Pipeline by Salesperson']");
	private By salesPersonPipelineReportChart = By.id("salesPersonPipelineReport");
	private By topTenCustomersHeader = By.xpath("//h2[text()='Top Ten Customers']");
	private By topTenCustomersReportChart = By.id("topTenCustomersReport");
	
	public void checkHomePage() {
		validation.validateElementIsExists(driver, dashboard, "Check Dashboard Menu");
		validation.validateElementIsExists(driver, leads, "Check Leads Menu");
		validation.validateElementIsExists(driver, customers, "Check Customers Menu");
		validation.validateElementIsExists(driver, opportunities, "Check Opportunities Menu");
		validation.validateElementIsExists(driver, workOrders, "Check Work orders Menu");
		validation.validateElementIsExists(driver, calendar, "Check Calender Menu");
		validation.validateElementIsExists(driver, admin, "Check Admin Menu");
		validation.validateElementIsExists(driver, hello, "Check Hello Menu");
		validation.validateElementIsExists(driver, logout, "Check Logout Menu");
		validation.validateElementIsExists(driver, companySalesReportsHeader, "Check Company Sales Reports Header");
		validation.validateElementIsExists(driver, salesReportChart, "Check Company Sales Reports Charts");
		validation.validateElementIsExists(driver, companyPipelineReportsHeader, "Check Company Pipeline Reports Header");
		validation.validateElementIsExists(driver, pipelineReportChart, "Check Company Pipeline Reports Charts");
		validation.validateElementIsExists(driver, salesbySalespersonHeader, "Check Sales by Salesperson Header");
		validation.validateElementIsExists(driver, salesPersonReportChart, "Check Sales by Salesperson Chart");
		validation.validateElementIsExists(driver, pipelinebySalespersonHeader, "Check Pipeline by Salesperson Header");
		validation.validateElementIsExists(driver, salesPersonPipelineReportChart, "Check Pipeline by Salesperson Chart");
		validation.validateElementIsExists(driver, topTenCustomersHeader, "Check Top Ten Customers Header");
		validation.validateElementIsExists(driver, topTenCustomersReportChart, "Check Top Ten Customers Chart");	
	}
	
	public void clickDashboardMenu() {
		common.clickElement(driver, dashboard, "Click On Dashboard Menu");
	}
	
	public void clickLeadsMenu() {
		common.clickElement(driver, leads, "Click On Leads Menu");
	}
	
	public void clickCustomersMenu() {
		common.clickElement(driver, customers, "Click On Customers Menu");
	}
	
	public void clickOpportunitiesMenu() {
		common.clickElement(driver, opportunities, "Click On Opportunities Menu");
	}
	
	public void clickWorkOrdersMenu() {
		common.clickElement(driver, workOrders, "Click On Work Orders Menu");
	}
	
	public void clickCalendarMenu() {
		common.clickElement(driver, calendar, "Click On Calendar Menu");
	}
	
	public void clickAdminMenu() {
		common.clickElement(driver, admin, "Click On Admin Menu");
	}
	
	public void clickLogoutMenu() {
		common.clickElement(driver, logout, "Click On Logout Menu");
	}
}
