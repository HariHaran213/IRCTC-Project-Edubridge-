package projectIRTC;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Contact_US {
	WebDriver driver;
	@BeforeMethod
	public void Contactus() {
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		
	    
	    }
	@Test
	public void TestingLink() {
		driver.findElement(By.linkText("CONTACT US")).click();
		WebElement emailLink = driver.findElement(By.linkText("care@irctc.co.in"));
		Assert.assertTrue(emailLink.isDisplayed());
		emailLink.click();
	}
	@AfterMethod
	public void close()
	{
		driver.quit();
	}
}
