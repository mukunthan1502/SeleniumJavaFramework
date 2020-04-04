package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import initialise.InitialiseBrowser;


public class Test1_GoogleSearch_TestNG_demo {

	WebDriver driver = null;
	
	@BeforeTest
	public void SetupTest() {
		driver = InitialiseBrowser.SetupBrowser("edge","http://www.google.com");
	}
	
	@Test
	public void GoogleSearch() {
		WebElement searchBar = driver.findElement(By.name("q"));
		searchBar.sendKeys("ABCDCBA");
		searchBar.submit();
	}
	
	@AfterTest
	public void TearDownTest() {
		driver.close();
		driver.quit();
		System.out.println("Test Completed Successfully");
		
		
	}
	
	
}
