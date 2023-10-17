package projectIRTC;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DailyDeals {
	WebDriver drivers;
	@BeforeMethod
	public void click() {
		WebDriverManager.edgedriver().setup();
		WebDriver drivers = new ChromeDriver();
		drivers.manage().window().maximize();
		drivers.navigate().to("https://www.irctc.co.in/nget/train-search");
		
		drivers.findElement(By.linkText("DAILY DEALS")).click();
		String parentWindow=drivers.getWindowHandle();
		Set<String> handles=drivers.getWindowHandles();
		for(String handle:handles)
			{
			if(!(handle==parentWindow))
			{
				drivers.switchTo().window(handle);
			}
			}
		drivers.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 14",Keys.ENTER);
		String parentWindow1=drivers.getWindowHandle();
		drivers.findElement(By.xpath("(//a[@class=\"a-link-normal s-no-outline\"])[1]")).click();
		Set<String> handles1=drivers.getWindowHandles();
		for(String handle1:handles1)
			{
			if(!(handle1==parentWindow1))
			{
				drivers.switchTo().window(handle1);
			}
			}
		WebElement buyNow=drivers.findElement(By.id("buy-now-button"));
		buyNow.click();
		
		
		
	}
	@Test
    public void amazonlogin() {
		WebElement username=drivers.findElement(By.id("ap_email"));	
		Assert.assertTrue(username.isDisplayed(), "username is not found");
		username.sendKeys("hariharan.v213@gmail.com");
		WebElement continurBtn=drivers.findElement(By.id("continue"));
		continurBtn.click();
        
    }
	@AfterMethod
	public void close()
	{
		drivers.quit();
	}
}


