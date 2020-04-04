package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import initialise.InitialiseBrowser;

@Listeners(listeners.TestNGListener.class)
public class Test1_GoogleSearch_TestNG_demo2 {

	WebDriver driver = null;
	
	@BeforeTest
	public void SetupTest() {
		driver = InitialiseBrowser.SetupBrowser("chrome","http:\\google.com");	
		System.out.println("BeforeTest");
	}
	
	@BeforeMethod
	public void BeforeEachTestcase() {
		driver.get("http:\\google.com");
		System.out.println("BeforeEachTest");
	}
	
	@Test
	public void GoogleSearch() {
		WebElement searchBar = driver.findElement(By.name("q"));
		searchBar.sendKeys("1");
		searchBar.submit();
		System.out.println("Test1");
	}
	
	@Test
	public void GoogleSearch2() {
		WebElement searchBar = driver.findElement(By.name("q"));
		searchBar.sendKeys("2");
		searchBar.submit();
		System.out.println("Test2");
	}
	
	@Test
	public void GoogleSearch3() {
		WebElement searchBar = driver.findElement(By.name("q"));
		searchBar.sendKeys("3");
		searchBar.submit();
		System.out.println("Test3");
	}
	
	@AfterMethod
	public void AfterEachTestcase() {
		driver.navigate().back();
		System.out.println("AfterEachTest");
	}
	
	@AfterTest
	public void TearDownTest() {
		driver.close();
		driver.quit();
		System.out.println("AfterTest");
		System.out.println("Tear Down Succesfully");
		
		
	}
	
	
	
	
	public static void main(String[] args) {

		WebDriver driver = InitialiseBrowser.SetupBrowser("firefox","http://www.google.com");
//		WebDriver driver = InitialiseBrowser.SetupBrowser("firefox");
		WebElement searchBar = driver.findElement(By.name("q"));
		searchBar.sendKeys("ABCD");
		searchBar.submit();

		
		

	}

}
