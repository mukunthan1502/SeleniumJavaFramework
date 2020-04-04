package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import initialise.InitialiseBrowser;

public class DesireCapabilities {

	
	public static void main(String[] args) {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("demo_capability", true);

		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		options.merge(capabilities);  //this will merge the capabilities to the ChromeOptions
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.get("https://google.com");


//		WebDriver driver = InitialiseBrowser.SetupBrowser("firefox","http://www.google.com");
//		WebDriver driver = InitialiseBrowser.SetupBrowser("firefox");
		WebElement searchBar = driver.findElement(By.name("q"));
		searchBar.sendKeys("ABCD");
		searchBar.submit();

		
		

	}

}
