package week5day1.assignments.ServiceNow;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateUpdate extends BaseService
{
	@Test
	public void createupdate() throws InterruptedException
	{

		
		driver.findElement(By.xpath("//span[@data-original-title='Search']")).click();
		driver.findElement(By.id("sysparm_search")).sendKeys(incidentpass,Keys.ENTER);
		Thread.sleep(2000);
		
		driver.switchTo().frame("gsft_main");
		
		Select dd1 = new Select(driver.findElement(By.id("incident.urgency")));
		dd1.selectByValue("1");
		Thread.sleep(1000);
		Select dd2 = new Select(driver.findElement(By.id("incident.state")));
		dd2.selectByValue("2");
		Thread.sleep(1000);
		driver.findElement(By.id("sysverb_update_bottom")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(incidentpass,Keys.ENTER);
		
		Thread.sleep(3000);
		
		
	}
	
}
