package demo;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import initialise.InitialiseBrowser;

public class TestNGMultipleBrowserDemo {
	
	@BeforeTest
	public void setupBrowser() {
		System.out.println("Current Thread: " +Thread.currentThread().getId());
	}
	
	@Parameters({"browser","url"})
	@Test
	public void testOne(String browser, String url) throws InterruptedException {
		WebDriver driver = InitialiseBrowser.SetupBrowser(browser);
		driver.get(url);
		Thread.sleep(3000);
//		System.out.println("Current thread: ");
		driver.close();
		
	}
	
	@AfterTest
	public void tearDown() {
		
	}
	
	

}
