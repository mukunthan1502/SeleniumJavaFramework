package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.PropertiesFile;
import initialise.InitialiseBrowser;
import pages.GoogleSearchPage;

public class SeleniumWaitDemo {
	
	public static void main(String[] args) throws InterruptedException {
		SeleniumWaitDemo.seleniumWaits();
	}
	
	public static void seleniumWaits() throws InterruptedException {
		
		String browser = PropertiesFile.getProperties("browser");
		String url = PropertiesFile.getProperties("url");
		
		WebDriver driver = InitialiseBrowser.SetupBrowser(browser, url);
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		GoogleSearchPage.textboxSearch(driver).sendKeys("Testing waits....");

		GoogleSearchPage.searchButton(driver).submit();
		
		GoogleSearchPage.textboxSearch(driver).sendKeys("Testing waits....");

		// ----- Explicit Wait ---------------------
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement searchButton =  wait.until(ExpectedConditions.elementToBeClickable(By.name("ABCD")));
		// ----- End of Explicit Wait ---------------------
		System.out.println("Wait wait wait");
//		driver.findElement(By.name("ABCD")).click();
		searchButton.click();
		

		GoogleSearchPage.searchButton(driver).submit();
		
		driver.close();
		driver.quit();
		
	}

}
