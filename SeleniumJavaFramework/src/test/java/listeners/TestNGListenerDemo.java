package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import initialise.InitialiseBrowser;
import utils.ExcelDataProvider;

@Listeners(listeners.TestNGListener.class)
public class TestNGListenerDemo {
	WebDriver driver = null;
	
	
	@BeforeSuite
	public void setupSuite() {


	}
	
	@BeforeTest
	public void setupTest() {
		
	}
	
	@Test(dataProvider = "browser_url_data")
	public void testCase1(String browser, String url) {
		driver = InitialiseBrowser.SetupBrowser(browser, url);
		
	}
	
/*	
	@Test
	public void test1() {
		System.out.println("I am inside 1");
	}
	
	@Test
	public void test2() {
		System.out.println("I am inside 2");
		Assert.assertTrue(false);
	}
	
	@Test
	public void test3() {
		System.out.println("I am inside 3");
		throw new SkipException("This test is skipped");
	}
*/	
	@DataProvider(name = "browser_url_data")
	public Object[][] getData() {
		String fileLocation = System.getProperty("user.dir")+ "//data//googletest.xlsx";
		String sheet = "Sheet1";
		return ExcelDataProvider.testData(fileLocation, sheet);
	}
}
