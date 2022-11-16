package com.parabank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BillPaymentCompletePage extends BasePage{
	public BillPaymentCompletePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h1[contains(.,'Bill Payment Complete')]")
	WebElement title;
	
	public void waitUntilBillPaymentIsConfirmed() {
		elementControl.waitUntilelementVisible(title);
	}
}
