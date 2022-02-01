package week5day1.assignments.ServiceNow;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class IncidentAssign extends BaseService
{
	@Test
	public void incidentassign() throws InterruptedException
	{
		
		driver.findElement(By.xpath("//span[@data-original-title='Search']")).click();
		driver.findElement(By.id("sysparm_search")).sendKeys(incidentpass,Keys.ENTER);
		Thread.sleep(2000);
		
		driver.switchTo().frame("gsft_main");
		
		driver.findElement(By.id("lookup.incident.assignment_group")).click();
		Thread.sleep(1000);
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));
		
		driver.findElement(By.xpath("(//label[text()='Search'])[2]/following-sibling::input")).sendKeys("Software",Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//table[@id='sys_user_group_table']/tbody[@class='list2_body']/tr[1]//a")).click();
		Thread.sleep(1000);
		
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> windows2 = new ArrayList<String>(windowHandles2);
		driver.switchTo().window(windows2.get(0));
		driver.switchTo().frame("gsft_main");
		
		driver.findElement(By.id("activity-stream-textarea")).sendKeys("My Assign work Notes");
		Thread.sleep(1000);
		String text2 = driver.findElement(By.id("sysverb_update_bottom")).getText();
		System.out.println(text2);
		driver.findElement(By.id("sysverb_update_bottom")).click();
		Thread.sleep(3000);
		
	}

}
