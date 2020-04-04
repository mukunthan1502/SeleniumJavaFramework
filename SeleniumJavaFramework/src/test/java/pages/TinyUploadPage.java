package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TinyUploadPage {
	
	private static WebElement element = null;
	private static By Uploadbutton = By.xpath("//img[@alt='Upload']");
	private static By FiletoUpload = By.name("uploaded_file");
	
	
	
	public static WebElement uploadButton(WebDriver driver) {
		
		element = driver.findElement(Uploadbutton);
		return element;
	}
	
	public static WebElement fileUploadButton(WebDriver driver) {
		
		element = driver.findElement(FiletoUpload);
		return element;
	}
	


}
