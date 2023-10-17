package projectIRTC;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Registration {
    private WebDriver driver;

    public Registration(WebDriver driver) {
        this.driver = driver;
    }
    
    public void navigateToRegistrationPage() {
        driver.get("https://www.irctc.co.in/nget/profile/user-registration");
        driver.manage().window().maximize();
    }

    public void BasicDetails () {
        WebElement userNameInput = driver.findElement(By.id("userName"));
        userNameInput.sendKeys("Hariharn");

        WebElement passwordInput = driver.findElement(By.id("usrPwd"));
        passwordInput.sendKeys("Service@123");

        WebElement confirmPasswordInput = driver.findElement(By.id("cnfUsrPwd"));
        confirmPasswordInput.sendKeys("Service@123");
    
       
        WebElement dropdown=driver.findElement(By.xpath("(//span[contains(@class,'ui-dropdown-trigger-icon ui-clickable')])[1]"));
        dropdown.click();
        WebElement dropdown1=driver.findElement(By.xpath("//ul[@role=\"listbox\"]"));
        List<WebElement> values=dropdown1.findElements(By.tagName("p-dropdownitem"));
        System.out.println(values.size());
        values.get(0).click();
        
        WebElement dropdown2=driver.findElement(By.className("ui-dropdown-trigger-icon ui-clickable ng-tns-c65-15 pi pi-chevron-down"));
        dropdown2.click();
        WebElement dropdown3=driver.findElement(By.xpath("//ul[@role=\"button\"]"));
        List<WebElement> values1=dropdown3.findElements(By.xpath("p-dropdownitem"));
        System.out.println(values1.size());
        values1.get(2).click();
        WebElement securityAnswer = driver.findElement(By.xpath("(//ul[@formcontrolname=\"secAns\"]"));
        securityAnswer.sendKeys("Amalorpavam");
        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"divMain\"]/div/app-user-registration/div/div/form/div/div[2]/div[2]/div[2]/button"));
        continueButton.click();
       }
      

    
    public void PersonalDetails()
    {
    	WebElement firstNameInput = driver.findElement(By.id("firstName"));
        firstNameInput.sendKeys("Hari");
        WebElement middleNameInput = driver.findElement(By.xpath("//ul[@name=\"middleName\"]"));
        middleNameInput.sendKeys("Haran");
        WebElement lastNameInput = driver.findElement(By.xpath("//ul[@name=\"lastname\"]"));
        lastNameInput.sendKeys("V");
        WebElement dropdown=driver.findElement(By.xpath("(//span[contains(@class,'ui-dropdown-trigger-icon ui-clickable')])[3]"));
        dropdown.click();
        WebElement dropdown4=driver.findElement(By.xpath("(//span[contains(@class,'ui-dropdown-items ui-dropdown-list ui-widget-content ui-widget ui-corner-all ui-helper-reset ng-tns-c65-16')])"));
        dropdown4.click();
        WebElement dropdown5=driver.findElement(By.xpath("//ul[@role=\"button\"]"));
        List<WebElement> values2=dropdown.findElements(By.xpath("p-dropdownitem"));
        System.out.println(values2.size());
        values2.get(5).click();
        driver.findElement(By.xpath("(//span[contains(@class,'ng-star-inserted ui-radiobutton-label ui-label-active')])")).click();
       //Country
        driver.findElement(By.xpath("(//span[contains(@class,'form-control ng-pristine ng-valid ng-touched')])")).click();
        driver.findElement(By.xpath("//ul[@value=\"9\"]"));
        List<WebElement> values3=dropdown.findElements(By.xpath("//input[@class=\"ng-star-inserted\"])[9]"));
        System.out.println(values3.size());
        values2.get(9).click();
        //Gender
        driver.findElement(By.xpath("(//span[contains(@class,'ui-button-text ui-clickable ng-star-inserted')])[1]")).click();
        //Enter email
        driver.findElement(By.id("email")).sendKeys("harifreak01@gmail.com");
        driver.findElement(By.id("mobile")).sendKeys("9944639892");
        //Country
        driver.findElement(By.xpath("(//span[contains(@class,'form-control ng-pristine ng-valid ng-touched')])")).click();
        driver.findElement(By.xpath("//ul[@value=\"9\"]"));
        List<WebElement> values4=dropdown.findElements(By.xpath("//ul[@class=\"ng-star-inserted\"])[10000]"));
        System.out.println(values4.size());
        values2.get(10000).click();
        driver.findElement(By.xpath("//*[@id='divMain']/div/app-user-registration/div/div/form/div/div[2]/div[2]/div[2]/button")).click();
    }
    public void Address() {
    	driver.findElement(By.id("resAddress1")).sendKeys("No:13");
    	driver.findElement(By.id("resAddress2")).sendKeys("Gandhi Street");
    	driver.findElement(By.xpath("//input[@name='resPinCode']")).sendKeys("605004");
    	WebElement dropdown=driver.findElement(By.xpath("(//select[@class,'form-control ng-pristine ng-invalid ng-touched')])"));
        dropdown.click();
        WebElement dropdown1=driver.findElement(By.xpath("//option[@size=\"5\"])[1]"));
        List<WebElement> values=dropdown1.findElements(By.xpath("//ul[@value=\"Pondicherry\"])"));
        System.out.println(values.size());
        values.get(0).click();
        //Select post office 
        driver.findElement(By.xpath("(//select[@class,'form-control ng-dirty ng-touched ng-invalid')])")).click();
        WebElement dropdown2=driver.findElement(By.xpath("//option[@class='ng-star-inserted'])[2]"));
        List<WebElement> values1=dropdown2.findElements(By.xpath("//ul[@value=\"Thengaithittu B.O\"])"));
        System.out.println(values.size());
        values1.get(2).click();
        //Phone Number
        driver.findElement(By.id("resPhone")).sendKeys("8825616483");
        driver.findElement(By.xpath("//ul[@role=\"radio\"]")).click();
        driver.findElement(By.xpath("//ul[@type=\"checkbox")).click();
        driver.findElement(By.xpath("//*[@id=\"divMain\"]/div/app-user-registration/div/div/form/div/div[2]/div[2]/div[2]/button")).click();
        
    }
    
    public void closeBrowser() {
        driver.quit();
    }

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new EdgeDriver();

        Registration registration = new Registration(driver);

        registration.navigateToRegistrationPage();
        registration.BasicDetails();
        registration.PersonalDetails();
        registration.closeBrowser();
    }
}
