package com.parabank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BillPayPage extends BasePage {
	public BillPayPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "payee.name")
	WebElement payeeName;

	@FindBy(name = "payee.address.street")
	WebElement payeeAddressStreet;

	@FindBy(name = "payee.address.city")
	WebElement payeeAddressCity;

	@FindBy(name = "payee.address.state")
	WebElement payeeAddressState;

	@FindBy(name = "payee.address.zipCode")
	WebElement payeeAddressZipcode;

	@FindBy(name = "payee.phoneNumber")
	WebElement payeePhoneNumber;

	@FindBy(name = "payee.accountNumber")
	WebElement payeeAccountNumber;

	@FindBy(name = "verifyAccount")
	WebElement verifyAccount;

	@FindBy(name = "amount")
	WebElement amountElement;

	@FindBy(name = "fromAccountId")
	WebElement fromAccountId;

	@FindBy(xpath = "//input[contains(@type,'submit')]")
	WebElement submitButton;

	@FindBy(xpath = "//form[@class='ng-pristine ng-valid']")
	WebElement form;

	public void payBill(String name, String street, String city, String state, String zipcode, String phoneNumber,
			String amount, String accountNum, String fromAccount) throws InterruptedException {
		elementControl.sendTexts(payeeName, name);
		elementControl.sendTexts(payeeAddressStreet, street);
		elementControl.sendTexts(payeeAddressCity, city);
		elementControl.sendTexts(payeeAddressState, state);
		elementControl.sendTexts(payeeAddressZipcode, zipcode);
		elementControl.sendTexts(payeePhoneNumber, phoneNumber);
		elementControl.sendTexts(payeeAccountNumber, accountNum);
		elementControl.sendTexts(verifyAccount, accountNum);

		elementControl.sendTexts(amountElement, amount);
		elementControl.selectElementByVisibleText(fromAccountId, fromAccount);

		elementControl.submit(submitButton);
	}

}
