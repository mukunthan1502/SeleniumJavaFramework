package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import initialise.InitialiseBrowser;
import pages.GoogleSearchPage;

public class GoogleSearchTest {

	public static void main(String[] args) {

		WebDriver driver = InitialiseBrowser.SetupBrowser("firefox","https://google.com");
//		WebDriver driver = InitialiseBrowser.SetupBrowser("firefox");

		GoogleSearchPage.textboxSearch(driver).sendKeys("ABCDE");
		GoogleSearchPage.searchButton(driver).submit();

		
		

	}

}
