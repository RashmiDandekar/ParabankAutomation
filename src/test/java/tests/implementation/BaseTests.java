package tests.implementation;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.parabank.pages.AccountDetailsPage;
import com.parabank.pages.AccountOverviewPage;
import com.parabank.pages.BillPayPage;
import com.parabank.pages.BillPaymentCompletePage;
import com.parabank.pages.HomePage;
import com.parabank.pages.OpenAccountPage;

import commonLibs.implementation.CommonDriver;
import commonLibs.implementation.ReportsUtils;
import commonLibs.utils.ConfigUtils;

public class BaseTests {

	CommonDriver cmnDriver;
	HomePage homepage;
	String browserType;
	String url;
	WebDriver driver;
	Properties property;
	String propertyFilename;
	String currentWorkingDirectory;
	OpenAccountPage openAccountPage;
	BillPayPage billPayPage;
	AccountDetailsPage accountDetailsPage;
	AccountOverviewPage accountOverviewPage;
	BillPaymentCompletePage billPaymentCompletePage;
	ReportsUtils reportUtils;

	@BeforeSuite
	public void preSetUp() throws Exception {
		currentWorkingDirectory = System.getProperty("user.dir");
		propertyFilename = currentWorkingDirectory + File.separator + "config" + File.separator + "config.properties";
		property = ConfigUtils.readProperties(propertyFilename);
		reportUtils = new ReportsUtils(currentWorkingDirectory + File.separator + "reports" + File.separator
				+ "parabankAutomationReports.html");
		url = property.getProperty("url");
		browserType = property.getProperty("browserType");
		System.out.println("preSetUp.");
	}

	@BeforeClass
	public void setup() throws Exception {
		cmnDriver = new CommonDriver(browserType);
		driver = cmnDriver.getDriver();
		cmnDriver.navigateToUrl(url);
		homepage = new HomePage(driver);
		openAccountPage = new OpenAccountPage(driver);
		billPayPage = new BillPayPage(driver);
		accountOverviewPage = new AccountOverviewPage(driver);
		accountDetailsPage = new AccountDetailsPage(driver);
		billPaymentCompletePage = new BillPaymentCompletePage(driver);
		System.out.println("SetUp.");
	}

	@AfterSuite
	public void tearDown() {
		cmnDriver.closeAllbrowsers();
		reportUtils.flushReport();
		System.out.println("tear down");
	}

}
