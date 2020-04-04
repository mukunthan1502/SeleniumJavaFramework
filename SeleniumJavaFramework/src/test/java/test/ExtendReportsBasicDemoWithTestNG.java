package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import config.PropertiesFile;
import initialise.InitialiseBrowser;
import pages.GoogleSearchPage;
import pages.GoogleSearchPageObject;
import utils.ExcelUtils;

public class ExtendReportsBasicDemoWithTestNG {

	private static WebDriver driver = null;
//	private static ExtentHtmlReporter htmlReporter = null;
	private static ExtentReports extent = null;
	static ExtentTest test = null;
	private static int i = 0;
	
		
		@BeforeSuite
		public static void setupTest() {
			
			System.out.println("Before Suit");
			//start reporters
			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReport_TestNG.html");
			
			// create ExtentReports and attach reporter(s)
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);			
		}
		
		@BeforeMethod
		public static void beforeTest() {
			System.out.println("Before Test");
			//String browser = PropertiesFile.getProperties("browser");
			String fileDirectory = System.getProperty("user.dir")+ "\\data\\googletest.xlsx";
			ExcelUtils searchData = new ExcelUtils(fileDirectory, "Sheet1");
			
			String browser =  searchData.readCellString(i, 0);
			String URL = searchData.readCellString(i, 1);
			System.out.println(browser+ " : " +URL);
			driver = InitialiseBrowser.SetupBrowser(browser); 
			driver.get(URL);

			i++;
		}
		
		@Test
		public static void testCase1() {
			test = extent.createTest("Google Search Test 1", "This test is to validate the google search function");
			test.info("Test 1 starts here");
			test.pass("Navigate to google seach page.");
			GoogleSearchPage.textboxSearch(driver).sendKeys("Test1");		//using static class
			test.pass("Enter search text.");
			GoogleSearchPage.searchButton(driver).submit();
			test.pass("Results shown correctly.");
			test.info("Test 1 ends here");
			System.out.println("Test 1 passed");
			PropertiesFile.setProperties("Test1", "Pass");
//			extent.flush();
		}
		
		@Test
		public static void testCase2() {
			test = extent.createTest("Yahoo Search Test", "This test validates yahoo search functionality");
			test.info("Test 2 starts here");
			test.pass("Navigate to yahoo seach page.");
			GoogleSearchPageObject google = new GoogleSearchPageObject(driver);
			google.sendTextSearch("Test2");				//using instance
			test.pass("Enter search text.");
			google.clickSearchButton();
			test.pass("Results shown correctly.");
			test.info("Test 2 ends here");
			System.out.println("Test 2 passed");
			PropertiesFile.setProperties("Test2", "Pass");
//			extent.flush();			
		}
		
		@Test
		public static void testCase3() {
			test = extent.createTest("Binng Search Test", "This test validates bing search functionality");
			test.info("Test 3 starts here");
			test.pass("Navigate to yahoo seach page.");
			GoogleSearchPage.textboxSearch(driver).sendKeys("Test3");		//using static class
			test.pass("Enter search text.");
			GoogleSearchPage.searchButton(driver).submit();
			test.pass("Results shown correctly.");
			test.info("Test 3 ends here");
			PropertiesFile.setProperties("Test3", "Pass");
			System.out.println("Test 3 passed");
//			extent.flush();			
		}
		
		@AfterMethod
		public static void afterTest() {
			System.out.println("After Test");
			driver.close();
		}
		
		
		@AfterSuite
		public static void closeTest() {

			System.out.println("end of testsuite");
			extent.flush();	
			PropertiesFile.setProperties("TestSuite", "Pass");
		}
		
		
		
		
		
		

		 
		 
		 



}
