package projectIRTC;

import java.time.Duration;
import java.util.Set;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Hotel {
	WebDriver driver;
	@BeforeMethod
	public void login() {
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
		driver.get("https://www.irctc.co.in/nget/train-search");
		String parentWindow=driver.getWindowHandle();
		WebElement dropdown=driver.findElement(By.xpath("(//a[@tabindex=\"0\"])[1]"));
		dropdown.click();
		WebElement closeDisha=driver.findElement(By.xpath("//img[@id='disha-banner-close']"));
		closeDisha.click();
		WebElement Hotels =  driver.findElement(By.xpath("(//label[text()='HOTELS'])[1]"));
		Hotels.click();
		Set<String> windowHandles=driver.getWindowHandles();
		Iterator<String> itr=windowHandles.iterator();
		String parentWindow1=itr.next();
		String childWindow=itr.next();
		driver.switchTo().window(childWindow);
		
	}
	@Test
	public void buses() {
		WebElement location=driver.findElement(By.xpath("//input[@id=\"filterText\"]"));
		location.sendKeys("Hyderabad");
		String enteredLocation = location.getAttribute("value");
	    Assert.assertEquals(enteredLocation, "Hyderabad", "Entered location is incorrect");
	}
	@AfterMethod
	public void close()
	{
		driver.quit();
	}
}
