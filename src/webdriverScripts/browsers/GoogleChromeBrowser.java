package webdriverScripts.browsers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GoogleChromeBrowser {

	// Declaring variable 'webDriver' of WebDriver Type
	WebDriver webDriver;

	// Declaring baseURL variable of String Type
	String baseUrl;

	@Test
	public void testGoogleChromeBrowser() {

		// Store Chrome Driver Path
		String exePath = System.getProperty("user.dir") + "\\drivers\\windows\\chromedriver.exe";

		// Setting Chrome Driver Path
		System.setProperty("webdriver.chrome.driver", exePath);

		// Initializing Google Chrome Driver
		webDriver = new ChromeDriver();

		// Assigning URL to variable baseUrl
		baseUrl = "http://not-just-a-tester.blogspot.in";

		// Open the link
		webDriver.get(baseUrl);

		// Maximize the window
		webDriver.manage().window().maximize();

		// Click on Selenium link
		webDriver.findElement(By.linkText("Automation")).click();

		// This will close the browser
		webDriver.quit();
	}

}
