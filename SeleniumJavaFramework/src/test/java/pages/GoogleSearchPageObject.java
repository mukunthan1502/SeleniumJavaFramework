package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPageObject {
	
	WebDriver driver = null;
	
	//By is an selenium class
	By textbox_search = By.name("q");  			//locator for objects
	By search_button = By.name("btnK"); 		//locator for objects
	
	public GoogleSearchPageObject(WebDriver driver) {
		this.driver = driver;
	}
		
	public void sendTextSearch(String searchText) {
		driver.findElement(textbox_search).sendKeys(searchText);
	}
	
	public void clickSearchButton() {
		driver.findElement(search_button).submit();
	}

}
