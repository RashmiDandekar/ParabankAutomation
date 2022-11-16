package com.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountOverviewPage extends BasePage {

	@FindBy(id = "accountTable")
	WebElement accountTable;

	public AccountOverviewPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickAccountNumTocheckAccountBalance(String accountNum) {
		elementControl.waitUntilelementVisible(accountTable);
		String xpathAccount = "//a[contains(text(),'" + accountNum + "')]";
		elementControl.clickElement(driver.findElement(By.xpath(xpathAccount)));
	}
}