package webdriverScripts.others;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FileUpload {

	// Declaring variable 'webDriver' of WebDriver Type
	WebDriver webDriver;

	// Declaring variable 'baseUrl' of String Type
	String baseUrl;

	@Test

	public void FileUploadExample() throws InterruptedException {

		// Initializing FireFox Driver
		webDriver = new FirefoxDriver();

		// Assigning URL to variable 'baseUrl'
		baseUrl = "http://www.htmlcodetutorial.com/forms/_INPUT_TYPE_FILE.html";

		// Open the link
		webDriver.get(baseUrl);

		// Maximize browser window
		webDriver.manage().window().maximize();

		//
		String fileForUpload = System.getProperty("user.dir") + "\\html\\line-shape.jpg";

		//
		webDriver.findElement(By.name("upfile")).sendKeys(fileForUpload);

		//
		webDriver.findElement(By.xpath("//input[@value='Submit']")).click();

		//
		Thread.sleep(6000);

		// This will close the browser
		webDriver.quit();

	}
}