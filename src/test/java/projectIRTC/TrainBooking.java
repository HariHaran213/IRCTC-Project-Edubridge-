package projectIRTC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TrainBooking {
	WebDriver driver;
	@BeforeMethod
	public void Trainbooking() {
		WebDriverManager.edgedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.navigate().to("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
	}	
	   @Test
		public void PerformTrainBooking() {
		WebElement fromStation = driver.findElement(By.xpath("//*[@id=\"origin\"]/span/input"));
        fromStation.sendKeys("CHENNAI EGMORE - MS (CHENNAI)");
        WebElement fromStation1 = driver.findElement(By.xpath("//*[@id=\"divMain\"]/div/app-main-page/div/div/div[1]/div[1]/div[1]/app-jp-input/div/form/div[2]/div[1]"));
        		fromStation1.click();
        		WebElement ToStation = driver.findElement(By.xpath("//*[@id=\"destination\"]/span/input"));
                ToStation.sendKeys("COIMBATORE JN - CBE (COIMBATORE))");
                WebElement ToStation1 = driver.findElement(By.xpath("//*[@id=\"destination\"]/span/div"));
                ToStation1.click();
                WebElement SearchBtn = driver.findElement(By.linkText("Try booking in Ask DISHA 2.0"));
                SearchBtn.click();
                
		}
	   @AfterMethod
	   public void tearDown() {
	            driver.quit();
	        
	   }
    }
	
