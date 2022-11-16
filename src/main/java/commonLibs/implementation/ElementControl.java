package commonLibs.implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementControl {

	WebDriver driver;

	public ElementControl(WebDriver driver) {
		this.driver = driver;
	}

	public void clickElement(WebElement element) {
		element.click();
	}

	public void sendTexts(WebElement element, String text) {
		element.sendKeys(text);
	}

	public void selectElementByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void submit(WebElement element) {
		element.submit();
	}

	public void waitUntilelementVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public String getTextOfElement(WebElement element) {
		return element.getText();
	}
	
	public String getInnerTextOfElement(WebElement element) {
		return element.getAttribute("innerText");
	}

}
