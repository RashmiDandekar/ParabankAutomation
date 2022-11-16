package com.parabank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.sun.tools.javac.util.List;

public class OpenAccountPage extends BasePage {

	public OpenAccountPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "type")
	WebElement typeOfAccount;

	@FindBy(id = "fromAccountId")
	WebElement fromAccountId;

	@FindBy(xpath = "//form[@class='ng-pristine ng-valid']")
	WebElement form;

	@FindBy(how = How.CSS, using = "input[type='submit']")
	WebElement submitButton;

	@FindBy(id = "newAccountId")
	WebElement newAccountId;

	public String openCheckingAccount() {
		elementControl.selectElementByVisibleText(typeOfAccount, "CHECKING");
		elementControl.clickElement(submitButton);
		elementControl.submit(submitButton);
		elementControl.waitUntilelementVisible(newAccountId);
		return elementControl.getTextOfElement(newAccountId);
	}

	public String openSavingAccount() {
		elementControl.selectElementByVisibleText(typeOfAccount, "SAVINGS");
		elementControl.clickElement(submitButton);
		elementControl.submit(submitButton);
		elementControl.waitUntilelementVisible(newAccountId);
		return elementControl.getTextOfElement(newAccountId);
	}

	public void clickNewaccountId() {
		elementControl.clickElement(newAccountId);
	}
}
