package com.AlliedInsulation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.AlliedInsulation.commonUtilities.CommonMethods;
import com.AlliedInsulation.commonUtilities.Validation;
import com.aventstack.extentreports.ExtentTest;

public class LoginPageObjects {

	public WebDriver driver;
	CommonMethods commonMethod = new CommonMethods();
	Validation validate = new Validation();

	public LoginPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	// Login Page Webelements
	private By userEmail = By.id("email");
	private By passWord = By.id("password");
	private By emailLabel = By.xpath("//label[text()='Email']");
	private By passwordLabel = By.xpath("//label[text()='Password']");
	private By passwordShowHideEyeIcon = By.xpath("//input[@id='password']//following-sibling::span");
	private By loginHeader = By.xpath("//h4[text()='Login']");
	private By logoOne = By.xpath("//h4[text()='Login']//preceding::img[1]");
	private By logoTwo = By.xpath("//h4[text()='Login']//preceding::img[2]");
	private By login = By.id("loginButton");
	private By footer = By.tagName("footer");
	private By errorMessage = By.id("errorMessage");// Empty Data Error Message
	private By InvalidMessage = By.id("InvalidMessage");// Invalid Data Error Message
	private By deactivateMessage = By.id("deactivateError");// Deactive Account Error Message

	// Reset Password Window
	private By resetHeader = By.tagName("h3");
	private By emailInResetWin = By.id("usremail");
	private By emailLabelInResetWin = By.xpath("//label[text()='Email address']");
	private By currentPasswordInResetWin = By.id("currentPassword");
	private By currentPasswordLabelInResetWin = By.xpath("//label[text()='Current Password']");
	private By currentPswdShowHideEyeInResetWin = By.xpath("//input[@id='currentPassword']//following-sibling::span");
	private By newPasswordInResetWin = By.id("newPassword");
	private By newPasswordLabelInResetWin = By.xpath("//label[text()='New Password']");
	private By newPswdShowHideEyeInResetWin = By.xpath("//input[@id='newPassword']//following-sibling::span");
	private By confirmPasswordInResetWin = By.id("confirmPassword");
	private By confirmPasswordLabelInResetWin = By.xpath("//label[text()='Confirm Password']");
	private By confirmPswdShowHideEyeInResetWin = By.xpath("//input[@id='confirmPassword']//following-sibling::span");
	private By closeXnResetWin = By.xpath("//h3//following-sibling::button[1]");
	private By continueInResetWin = By.id("changePassword");
	private By closeInResetWin = By.xpath("//button[text()='Close']");
	private By emptyDataErrorInResetWin = By.id("errorMessage1");
	private By pswdDoestNotMatchErrorInResetWin = By.id("passwordmatch");

	public void checkLoginPage() {
		validate.validateElementIsExists(driver, loginHeader, "Check Login Header");
		validate.validateElementIsExists(driver, emailLabel, "Check Email Label");
		validate.validateElementIsExists(driver, passwordLabel, "Check Password Label");
		validate.validateElementIsExists(driver, passwordShowHideEyeIcon, "Check Password Show/Hide Eye Icon");
		validate.validateElementIsExists(driver, logoOne, "Check Header Logo");
		validate.validateElementIsExists(driver, logoTwo, "Check Title Logo");
		validate.validateElementIsExists(driver, passwordLabel, "Check Password Label");
		validate.validateElementIsExists(driver, footer, "Check Footer Label");
	}

	public void clickLogin() {
		commonMethod.clickElement(driver, login, "Click On Login");
	}

	public void checkLoginPageTitle(String title) {
		validate.validatePageTitle(driver, title, "Check Login Page Title");
	}

	public void checkLoginPageURL(String Url) {
		validate.validatePageUrl(driver, Url, "Check Login Page URL");
	}

	public void enterUserEmail(String email) throws InterruptedException {
		commonMethod.enterValue(driver, userEmail, email, "Enter Email Id :" + email);
	}

	public void enterPassword(String password) {
		commonMethod.enterValue(driver, passWord, password, "Enter Password " + password);
	}

	public void clickPasswordShowHideEyeIcon() {
		commonMethod.clickElement(driver, passwordShowHideEyeIcon, "Click On Password Show/Hide Eye Icon");
	}

	public void checkEmptyDataErrorMessage(String expectedError) {
		validate.validateElementIsExists(driver, errorMessage,
				"Check Login With Empty Data  Error Message Is Presented");
		validate.validateText(driver, errorMessage, expectedError, "Check Login With Empty Data");
	}

	public void checkInvalidDataErrorMessage(String expectedError) {
		validate.validateElementIsExists(driver, InvalidMessage, "Check Invalid Data Error Message Is Presented");
		validate.validateText(driver, InvalidMessage, expectedError, "Check Login With Invalida Data");
	}

	public void checkDeactivatedAccErrorMessage(String expectedError) {
		validate.validateElementIsExists(driver, errorMessage,
				"Check Login With Empty Data  Error Message Is Presented");
		validate.validateText(driver, errorMessage, expectedError, "Check Login With Empty Data");
	}

	// Check Reset Password Window
	public void checkResetPasswordWindow() {
		validate.validateElementIsExists(driver, resetHeader, "Check Reset Password Header");
		validate.validateElementIsExists(driver, closeXnResetWin, "Check Close X Option On Reset Password window");
		validate.validateElementIsExists(driver, closeInResetWin, "Check Close Option On Reset Password window");
		validate.validateElementIsExists(driver, continueInResetWin, "Check Continue Option On Reset Password window");
		validate.validateElementIsExists(driver, emailInResetWin, "Check Email Field On Reset Password window");
		validate.validateElementIsExists(driver, emailLabelInResetWin,
				"Check Email Address Label On Reset Password window");
		validate.validateElementIsExists(driver, currentPasswordLabelInResetWin,
				"Check Current Password On Reset Password window");
		validate.validateElementIsExists(driver, currentPasswordInResetWin,
				"Check Current Password Label On Reset Password window");
		validate.validateElementIsExists(driver, currentPswdShowHideEyeInResetWin,
				"Check Current Password Show/Hide Eye Icon On Reset Password window");
		validate.validateElementIsExists(driver, newPasswordInResetWin, "Check New Password On Reset Password window");
		validate.validateElementIsExists(driver, newPasswordLabelInResetWin,
				"Check New Password Label On Reset Password window");
		validate.validateElementIsExists(driver, newPswdShowHideEyeInResetWin,
				"Check New Password Show/Hide Eye Icon On Reset Password window");
		validate.validateElementIsExists(driver, confirmPasswordInResetWin,
				"Check Confirm Password On Reset Password window");
		validate.validateElementIsExists(driver, confirmPasswordLabelInResetWin,
				"Check Confirm Password Label On Reset Password window");
		validate.validateElementIsExists(driver, confirmPswdShowHideEyeInResetWin,
				"Check Confirm Password Show/Hide Eye Icon On Reset Password window");
	}

	public void clickCloseXInWindow() {
		commonMethod.clickElement(driver, closeXnResetWin, "Click Close X Option On Reset Password Window");
	}

	public void clickContinueInResetWindow() {
		commonMethod.clickElement(driver, continueInResetWin, "Click Continue Option On Reset Password Window");
	}

	public void clickCloseInResetWindow() {
		commonMethod.clickElement(driver, closeXnResetWin, "Click Close Option On Reset Password Window");
	}

	public void checkErrorForPasswordNotMatch() {
		validate.validateText(driver, pswdDoestNotMatchErrorInResetWin, "The password confirmation does not match.",
				"Check The password confirmation does not match. error");
	}

	public void checkErrorForInvalidaDataMatch() {
		validate.validateText(driver, emptyDataErrorInResetWin, "Please enter valid credentials.",
				"Check Please enter valid credentials. error");
	}
}
