package initialise;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;



public class InitialiseBrowser {

	public enum Browser {
		Firefox,
		Chrome,
		Edge,
		IE,
	}
	public static WebDriver SetupBrowser(String browser) {
		String ProjectPath = System.getProperty("user.dir");
		if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ProjectPath +"\\Browser Drivers\\geckodriver.exe");	//GeckoDriver for FireFox
			return new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ProjectPath +"\\Browser Drivers\\chromedriver.exe");	//ChromeDriver for Chrome
			return new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", ProjectPath +"\\Browser Drivers\\msedgedriver.exe");	//EdgeDriver for EDGE
			return new EdgeDriver();
		}
		else {  //Internet Explorer
			System.setProperty("webdriver.ie.driver", ProjectPath +"\\Browser Drivers\\IEDriverServer.exe");	//IEDriver for IE
			return new InternetExplorerDriver();
		}
	}
	
	public static WebDriver SetupBrowser(String browser, String URL) {
		String ProjectPath = System.getProperty("user.dir");
		WebDriver tempDriver;
		if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ProjectPath +"\\Browser Drivers\\geckodriver.exe");	//GeckoDriver for FireFox
			tempDriver = new FirefoxDriver();
			tempDriver.get(URL);
			return tempDriver;
		}
		else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ProjectPath +"\\Browser Drivers\\chromedriver.exe");	//ChromeDriver for Chrome
			tempDriver = new ChromeDriver();
			tempDriver.get(URL);
			return tempDriver;
		}
		else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", ProjectPath +"\\Browser Drivers\\msedgedriver.exe");	//EdgeDriver for EDGE
			tempDriver = new EdgeDriver();
			tempDriver.get(URL);
			return tempDriver;
		}
		else {  //Internet Explorer
			System.setProperty("webdriver.ie.driver", ProjectPath +"\\Browser Drivers\\IEDriverServer.exe");	//IEDriver for IE
			tempDriver = new InternetExplorerDriver();
			tempDriver.get(URL);
			return tempDriver;
		}
	}
	
	public static void CloseBrowser(WebDriver Driver) {
		Driver.close();
		System.out.println("Tear Down Succesfully");
	}
}