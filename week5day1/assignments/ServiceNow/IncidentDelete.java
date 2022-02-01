package week5day1.assignments.ServiceNow;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class IncidentDelete extends BaseService
{
	@Test (priority=4)
	public void incidentdelete() throws InterruptedException
	{
		
		driver.findElement(By.xpath("//span[@data-original-title='Search']")).click();
		driver.findElement(By.id("sysparm_search")).sendKeys(incidentpass,Keys.ENTER);
		Thread.sleep(2000);
		
		driver.switchTo().frame("gsft_main");
		
		driver.findElement(By.id("sysverb_delete_bottom")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("ok_button")).click();
		Thread.sleep(1000);
		
		driver.switchTo().defaultContent();
		driver.findElement(By.id("sysparm_search")).clear();
		driver.findElement(By.id("sysparm_search")).sendKeys(" ",Keys.ENTER);
		driver.findElement(By.id("sysparm_search")).sendKeys(incidentpass,Keys.ENTER);
		
		
		
	}

}

