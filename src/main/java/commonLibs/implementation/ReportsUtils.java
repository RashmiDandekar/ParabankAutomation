package commonLibs.implementation;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ReportsUtils {

	ExtentHtmlReporter htmlReporter;
	ExtentReports reports;
	ExtentTest extentTest;

	public ReportsUtils(String fileName) {
		fileName = fileName.trim();
		htmlReporter = new ExtentHtmlReporter(fileName);

		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
	}

	public void createNewTestCase(String testCase) {
		extentTest = reports.createTest(testCase);
	}

	public void testLog(Status status, String comment) {
		extentTest.log(status, comment);
	}
	
	public void flushReport() {
		reports.flush();
	}

}
