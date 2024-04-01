package Driver_manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

public class BrowserStackTest  {

	public static final String USERNAME =  "asis_f8yHV3";
	public static final String AUTOMATE_KEY ="j3gUzrvyWWzqL7zxDE9A" ;
	public static final String BROWSERSTACK_URL = "https://automate.browserstack.com/dashboard/v2/quick-start/setup-browserstack-sdk";
	  public static void main(String[] args) throws Exception {

	        DesiredCapabilities caps = new DesiredCapabilities();

	        // Set BrowserStack capabilities in W3C format
	        caps.setCapability("browser", "Chrome");
	        caps.setCapability("browser_version", "latest");
	        caps.setCapability("os", "Windows");
	        caps.setCapability("os_version", "10");
	        caps.setCapability("name", "Sample Selenium Test");

	        WebDriver driver = new RemoteWebDriver(new URL(BROWSERSTACK_URL), caps);

	        // Navigate to a website and perform some actions
	        driver.get("https://www.example.com");
	        System.out.println("Title of the page is: " + driver.getTitle());

	        // Your test steps here...

	        // Close the browser
	        driver.quit();
	    }
	}
