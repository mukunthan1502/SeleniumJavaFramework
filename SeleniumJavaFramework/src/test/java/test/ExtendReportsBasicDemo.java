package test;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import initialise.InitialiseBrowser;
import pages.GoogleSearchPageObject;

public class ExtendReportsBasicDemo {

	private static WebDriver driver = null;
	
	public static void main(String[] args) {

		 ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
		 
		 ExtentReports extent = new ExtentReports();
		 extent.attachReporter(htmlReporter);
		 
		 ExtentTest test = extent.createTest("Google Search Test 1", "This test is to validate the google search function");
		 
		 test.info("Test starts here.");
		 
		 driver = InitialiseBrowser.SetupBrowser("firefox", "http:\\google.com");
		 test.pass("Navigated to google home page.");
		 
		 GoogleSearchPageObject googleTest = new GoogleSearchPageObject(driver);
		 
		 googleTest.sendTextSearch("TABCD");
		 test.pass("Entered text to search on google search bar.");
		 
		 googleTest.clickSearchButton();
		 test.pass("Search button clicked.");
		 
		 InitialiseBrowser.CloseBrowser(driver);
		 test.pass("Closed the browser successfully.");
		 
		 extent.flush();
		 
		 
		 

	}

}
