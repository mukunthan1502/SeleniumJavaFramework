package demo;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.PropertiesFile;
import initialise.InitialiseBrowser;
import pages.GoogleSearchPage;


public class FluentWaitDemo {

	public static void main(String[] args) {
		fluentWait();
	}

	public static void fluentWait() {

		WebDriver driver = InitialiseBrowser.SetupBrowser(PropertiesFile.getProperties("browser"), PropertiesFile.getProperties("url"));

		GoogleSearchPage.textboxSearch(driver).sendKeys("ABCD");
		GoogleSearchPage.searchButton(driver).submit();

		//By LinkID = By.partialLinkText("ABCD Alphabet");
		By XPath = By.xpath("//*[@id=\"rso\"]/div[1]/div/div[1]/a/h3");

		// -----Explicit WAit ------
		/*
		WebDriverWait wait = new WebDriverWait(driver, 10);
		System.out.println("wait");
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(XPath));
		System.out.println("found");
		element.click();
		System.out.println("clicked");
		 */
		//------END-----

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);

		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(XPath));
/*		
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {

			@Override
			public WebElement apply(WebDriver t) {
				WebElement element = driver.findElement(XPath);
				return element;
			}
		});
*/		
		element.click();






	}





}
