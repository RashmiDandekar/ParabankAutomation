package com.parabank.pages;

import org.openqa.selenium.WebDriver;

import commonLibs.implementation.CommonDriver;
import commonLibs.implementation.ElementControl;

public class BasePage {
	
	WebDriver driver;
	
	ElementControl elementControl;
	
	public BasePage(WebDriver driver) {
		this.driver=driver;
		elementControl= new ElementControl(driver);
	}

}
