package commonLibs.implementation;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CommonDriver {

	private WebDriver driver;
	private int pageLoadTime;
	private int elementDetectionTime;
	private String currentworkingDirectory;

	public CommonDriver(String browserType) throws Exception {
		pageLoadTime = 10;
		elementDetectionTime = 10;
		currentworkingDirectory = System.getProperty("user.dir");
		if (browserType.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					currentworkingDirectory + File.separator + "drivers" + File.separator + "chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserType.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver",
					currentworkingDirectory + File.separator + "drivers" + File.separator + "msedgedriver.exe");
			driver = new EdgeDriver();
		} else {
			throw new Exception("Invalid browser type");
		}
	}

	public void navigateToUrl(String url) {
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(pageLoadTime, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(elementDetectionTime, TimeUnit.SECONDS);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public void setPageLoadTime(int pageLoadTime) {
		this.pageLoadTime = pageLoadTime;
	}

	public void setElementDetectionTime(int elementDetectionTime) {
		this.elementDetectionTime = elementDetectionTime;
	}

	public void closeAllbrowsers() {
		driver.quit();
	}

}
