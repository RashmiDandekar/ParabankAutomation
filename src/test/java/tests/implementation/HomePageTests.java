package tests.implementation;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.parabank.pages.HomePage;

public class HomePageTests extends BaseTests {

	String accountNum;
	String fromAccount;

	@Parameters({ "username", "password" })
	@Test(priority = 1)
	public void verifyLoginWithCorrectCredentials(String username, String password) {
		reportUtils.createNewTestCase("Verify Login With Correct Credentials");

		reportUtils.testLog(Status.INFO, "Performing Login");
		homepage.loginFunctionality(username, password);

		String actualTitle = cmnDriver.getPageTitle();
		String expectedTitle = "ParaBank | Accounts Overview";

		reportUtils.testLog(Status.DEBUG, "Checking if login is successful");
		Assert.assertEquals(actualTitle, expectedTitle);
		reportUtils.testLog(Status.PASS, "Login Succeeded");
	}

	@Test(priority = 2)
	public void verifyOpeningOfCheckingAccount() {
		reportUtils.createNewTestCase("Verify Opening Of Checking Account");

		reportUtils.testLog(Status.INFO, "Loading 'Open Account' page");
		homepage.loadOpenAccountPage();

		reportUtils.testLog(Status.INFO, "Entering Detains");
		accountNum = openAccountPage.openCheckingAccount();
		System.out.println("accountNum:" + accountNum);
		openAccountPage.clickNewaccountId();

		String expectedTitle = "ParaBank | Account Activity";
		String actualTitle = cmnDriver.getPageTitle();

		Assert.assertEquals(actualTitle, expectedTitle);
		reportUtils.testLog(Status.PASS, "Checking account has been successfully created");

	}

	@Test(priority = 3)
	public void verifyOpeningOfSavingAccount() {
		reportUtils.createNewTestCase("Verify Opening Of Checking Account");

		reportUtils.testLog(Status.INFO, "Loading 'Open Account' page");
		homepage.loadOpenAccountPage();

		reportUtils.testLog(Status.INFO, "Entering Detains");
		fromAccount = openAccountPage.openSavingAccount();
		System.out.println("fromAccount:" + fromAccount);
		openAccountPage.clickNewaccountId();

		String expectedTitle = "ParaBank | Account Activity";
		String actualTitle = cmnDriver.getPageTitle();

		Assert.assertEquals(actualTitle, expectedTitle);
		reportUtils.testLog(Status.PASS, "Checking account has been successfully created");
	}

	@Parameters({ "payeeName", "payeeAddressStreet", "payeeAddressCity", "payeeAddressState", "payeeAddressZipcode",
			"payeePhoneNumber", "amount" })
	@Test(priority = 4)
	public void verifyBillPaymentAndAccountBalance(String name, String street, String city, String state,
			String zipcode, String phoneNumber, String amount) throws InterruptedException {
		
		reportUtils.createNewTestCase("Verify Bill Payment And Account Balance");
		
		reportUtils.testLog(Status.INFO, "Loading 'Bill Pay' page");
		homepage.loadBillPaymentPage();
		
		reportUtils.testLog(Status.INFO, "Entering Detains");
		billPayPage.payBill(name, street, city, state, zipcode, phoneNumber, amount, accountNum, fromAccount);
		billPaymentCompletePage.waitUntilBillPaymentIsConfirmed();

		String expectedTitle = "ParaBank | Bill Payment Complete";
		String actualTitle = cmnDriver.getPageTitle();

		reportUtils.testLog(Status.DEBUG, "Checking if bill payment is successful");
		Assert.assertEquals(actualTitle, expectedTitle);
		reportUtils.testLog(Status.PASS, "Bill Paid successfully");

		homepage.loadAccountOverViewPage();
		accountOverviewPage.clickAccountNumTocheckAccountBalance(fromAccount);
		reportUtils.testLog(Status.DEBUG, "Verifying account details");
		String fromAccountBalance = accountDetailsPage.getBalance();

		String fromAccountComparison = "$50.00";

		Assert.assertEquals(fromAccountBalance, fromAccountComparison);
		reportUtils.testLog(Status.PASS, "Account remaining balance :"+fromAccountBalance);
	}

}
