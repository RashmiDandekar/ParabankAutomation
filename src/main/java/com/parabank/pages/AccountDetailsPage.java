package com.parabank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonLibs.implementation.ElementControl;

public class AccountDetailsPage extends BasePage{

	public AccountDetailsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="accountId")
	WebElement accountId;
	
	@FindBy(id="accountType")
	WebElement accountType;
	
	@FindBy(xpath = "//td[contains(.,'$')]")
	WebElement balance;
	
	public String getAccountType() {
		elementControl.waitUntilelementVisible(accountType);
		return elementControl.getTextOfElement(accountType);
	}
	
	public String getAccountId() {
		elementControl.waitUntilelementVisible(accountId);
		return elementControl.getTextOfElement(accountId);
	}
	
	public String getBalance() {
		elementControl.waitUntilelementVisible(balance);
		System.out.println("balance:"+elementControl.getTextOfElement(balance));
		return elementControl.getTextOfElement(balance);
	}
}
