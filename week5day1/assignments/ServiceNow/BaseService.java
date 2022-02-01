package week5day1.assignments.ServiceNow;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseService {
	public  ChromeDriver driver;
	public static String  incidentpass;
	
	 @BeforeMethod
	public  void beforemethod() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://dev83049.service-now.com/login.do?");
		Thread.sleep(2000);		
		driver.findElement(By.id("user_name")).sendKeys("admin");		
		driver.findElement(By.id("user_password")).sendKeys("Anju@admin123");
		driver.findElement(By.id("sysverb_login")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='filter']")).clear();
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("incident");
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
			

	}
	 
	 @AfterMethod
	  public void afterMethod() 
	  {
		  driver.close();
	  }

}
