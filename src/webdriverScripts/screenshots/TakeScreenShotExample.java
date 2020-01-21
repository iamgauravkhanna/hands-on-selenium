package webdriverScripts.screenshots;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeScreenShotExample {
	
	public static void main(String [] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();

		WebDriver webDriverObj = new ChromeDriver();
		
		webDriverObj.get("https://www.google.com");
		
		// Cast driver object to TakesScreenshot
		TakesScreenshot screenshot = (TakesScreenshot) webDriverObj;
		
		// Get the screenshot as an image File
		File fileObj = screenshot.getScreenshotAs(OutputType.FILE);
		
		String screenShotObj = screenshot.getScreenshotAs(OutputType.BASE64) ;
		
		File fileBase64Obj = OutputType.FILE.convertFromBase64Png(screenShotObj);
		
		FileUtils.copyFile(fileObj, new File("resources/screenshot1.png"),true);
		
		FileUtils.copyFile(fileBase64Obj, new File("resources/screenshot2.png"),true);
		
		webDriverObj.quit();		
		
	}

}
