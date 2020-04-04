package test;

import org.openqa.selenium.WebDriver;

import initialise.InitialiseBrowser;
import pages.GoogleSearchPageObject;


public class GoogleSearchTestofPageObj {
	
	static WebDriver driver = null;

	
	public static void main(String[] args) {
		googleSearchPageTest();
	}
	
	public static void googleSearchPageTest() {
		
		for(InitialiseBrowser.Browser testBrowser: InitialiseBrowser.Browser.values()) {
			driver = InitialiseBrowser.SetupBrowser(testBrowser.toString(), "http:\\google.com");
			GoogleSearchPageObject testCase = new GoogleSearchPageObject(driver);
			testCase.sendTextSearch("ABCD");
			testCase.clickSearchButton();
		}
/*		
		driver = InitialiseBrowser.SetupBrowser("firefox", "http:\\google.com");
		GoogleSearchPageObject testCase = new GoogleSearchPageObject(driver);
		testCase.sendTextSearch("ABCD");
		testCase.clickSearchButton();

		driver = InitialiseBrowser.SetupBrowser("chrome", "http:\\google.com");
		testCase = new GoogleSearchPageObject(driver);
		testCase.sendTextSearch("ABCD");
		testCase.clickSearchButton();
		
		driver = InitialiseBrowser.SetupBrowser("edge", "http:\\google.com");
		testCase = new GoogleSearchPageObject(driver);
		testCase.sendTextSearch("ABCD");
		testCase.clickSearchButton();
		
		driver = InitialiseBrowser.SetupBrowser("ie", "http:\\google.com");
		testCase = new GoogleSearchPageObject(driver);
		testCase.sendTextSearch("ABCD");
		testCase.clickSearchButton();
*/	}

}
