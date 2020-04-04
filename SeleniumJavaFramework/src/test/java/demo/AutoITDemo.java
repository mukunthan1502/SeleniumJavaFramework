package demo;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.PropertiesFile;
import initialise.InitialiseBrowser;
import pages.TinyUploadPage;

public class AutoITDemo {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		test();
	}
	
	public static void test() throws InterruptedException, IOException {
		

		String url = "http://www.tinyupload.com/";
		String scriptLocation = "C:\\Selenium Projects\\SeleniumJavaFramework\\FileUploadScript.exe";
		WebDriver driver = InitialiseBrowser.SetupBrowser(PropertiesFile.getProperties("browser"), url);

		Actions builder = new Actions(driver);
		
	

		WebElement fileUpload = TinyUploadPage.fileUploadButton(driver);
		builder.moveToElement(fileUpload).click().build().perform();
	

		
		Runtime.getRuntime().exec(scriptLocation);
		
		Thread.sleep(9000);
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement uploadButton = wait.until(ExpectedConditions.elementToBeClickable(TinyUploadPage.uploadButton(driver)));
			
		System.out.println(uploadButton.isDisplayed());
		
		builder.moveToElement(uploadButton).click().build().perform();
		
		
		
//		System.out.println(upload.isDisplayed());
//		upload.sendKeys(Keys.RETURN);
//		TinyUploadPage.fileUploadButton(driver)
		
//		TinyUploadPage.uploadButton(driver).click();
		
	
		
		
		
	}

}
