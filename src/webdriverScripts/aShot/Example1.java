package webdriverScripts.aShot;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class Example1 {

	@Test
	public void TestCase001() throws InterruptedException, IOException {

		String baseUrl = "https://www.timespoints.com/";

		WebDriverManager.firefoxdriver().setup();

		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();

		driver.get(baseUrl);

		checkIfPageIsLoaded(driver);

		driver.get("https://www.timespoints.com/products");

		checkIfPageIsLoaded(driver);

		driver.findElement(By.xpath("//p[contains(text(),'Cricplay')]")).click();

		driver.get(baseUrl);

		driver.findElement(By.xpath("//div[@class='user-nav']//span")).click();

		checkIfPageIsLoaded(driver);

		driver.findElement(By.xpath("//input[@name='emailId']")).sendKeys("gaurav.khanna@timesinternet.in");

		driver.findElement(By.xpath("//input[@name='emailId']")).sendKeys(Keys.ENTER);

		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Twid@2019");

		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@value='Sign In']")).click();

		checkIfPageIsLoaded(driver);

		driver.findElement(By.xpath("//h3[text()='Gaurav']")).click();

		driver.findElement(By.xpath("//a[text()='earn']")).click();

		checkIfPageIsLoaded(driver);

		driver.findElement(By.xpath("//h4[text()='Earn WITH']")).click();

		checkIfPageIsLoaded(driver);

		driver.findElement(By.xpath("//a[text()='redeem']")).click();

		driver.findElement(By.xpath("//p[contains(text(),'Cricplay')]")).click();

		checkIfPageIsLoaded(driver);

		// Actions actions = new Actions(driver);

		// driver.findElement(By.xpath("//span[@class='user-name']")).click();

		// WebElement subMenuOption =
		// driver.findElement(By.xpath("//span[@class='user-name']"));

		// actions.moveToElement(subMenuOption).perform();

		// Thread.sleep(2000);

		// driver.findElement(By.xpath("//a[@href='/profile/complete'][@data-label='Profile']")).click();

		WebElement element1 = driver.findElement(By.xpath("//span[@class='user-name']"));

		// driver.execute_script("arguments[0].setAttribute('style','visibility:visible;');",element1);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].setAttribute('style','visibility:visible;');", element1);

		// driver.findElement(By.xpath("//a[@href='/profile/complete'][@data-label='Profile']")).click();

		driver.get("https://www.timespoints.com/profile/complete");

		checkIfPageIsLoaded(driver);

		driver.findElement(By.xpath("//a[text()='PROFILE']")).click();

		driver.get("https://www.timespoints.com/profile/complete");

		checkIfPageIsLoaded(driver);

		driver.get("https://www.timespoints.com/wishlist");

		checkIfPageIsLoaded(driver);

		driver.get("https://www.timespoints.com/refer-earn");

		checkIfPageIsLoaded(driver);

		driver.get("https://www.timespoints.com/history");

		checkIfPageIsLoaded(driver);

	}

	private static void checkIfPageIsLoaded(WebDriver driver) {

		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};

		try {

			Thread.sleep(1000);

			WebDriverWait wait = new WebDriverWait(driver, 30);

			wait.until(expectation);

			System.out.println("Page is in readyState");

		} catch (Throwable error) {

			Assert.fail("Timeout waiting for Page Load Request to complete.");

		}

	}

}