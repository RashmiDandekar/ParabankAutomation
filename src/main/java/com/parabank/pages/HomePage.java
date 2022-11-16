package com.parabank.pages;

import java.net.http.WebSocketHandshakeException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

	@FindBy(name = "username")
	WebElement uname;

	@FindBy(name = "password")
	WebElement upass;

	@FindBy(name = "login")
	WebElement login;

	@FindBy(linkText = "Open New Account")
	WebElement openNewAccount;

	@FindBy(linkText = "Bill Pay")
	WebElement billPay;
	
	@FindBy(linkText = "Accounts Overview")
	WebElement accountOverview;

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void loginFunctionality(String username, String password) {
		elementControl.sendTexts(uname, username);
		elementControl.sendTexts(upass, password);
		elementControl.submit(login);
	}

	public void loadOpenAccountPage() {
		elementControl.clickElement(openNewAccount);
	}

	public void loadBillPaymentPage() {
		elementControl.clickElement(billPay);
	}
	
	public void loadAccountOverViewPage() {
		elementControl.clickElement(accountOverview);
	}
}
