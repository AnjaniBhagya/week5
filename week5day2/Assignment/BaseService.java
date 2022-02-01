package week5day2.Assignment;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseService {

	public static ChromeDriver driver;
	public String filename;

	@Parameters({"url","username","password"})
	@BeforeMethod
	public void baseservice(String url,String username,String password) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get(url);
		Thread.sleep(1000);		
		driver.findElement(By.id("user_name")).sendKeys(username);		
		driver.findElement(By.id("user_password")).sendKeys(password);
		driver.findElement(By.id("sysverb_login")).click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='filter']")).clear();
		Thread.sleep(500);

		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("Incident");	
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);

	}

	@AfterMethod
	public void afterservice()
	{
		driver.close();
	}
	
	 @DataProvider(name = "serviceData")
	  public String[][] sendData() throws IOException {
		  return ReadExcel.read(filename); 
	  }
}
