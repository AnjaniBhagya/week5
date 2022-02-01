package week5day1.assignments.ServiceNow;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class Create extends BaseService
{ 
	@Test 
	public void create() throws InterruptedException
	{
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//span[@id='incident_breadcrumb']/a[1]")).click();
		driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
		driver.findElement(By.xpath("//button[@id='lookup.incident.caller_id']")).click();
		Thread.sleep(2000);
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));
		
		driver.findElement(By.xpath("//table[@id='sys_user_table']//tr[1]/td[3]/a")).click();
		
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> windows2 = new ArrayList<String>(windowHandles2);
		driver.switchTo().window(windows2.get(0));
		Thread.sleep(2000);
		
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys("Short Description to new create");	
		String inciNum = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
		incidentpass = inciNum;
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(
				"//span[text()='Press Enter from within the input to submit the search.']/following-sibling::input"))
				.sendKeys(inciNum,Keys.ENTER);
		Thread.sleep(1000);
		
		String incinum2 = driver.findElement(By.xpath("//table[@id='incident_table']//tr[1]/td[3]")).getText();
		System.out.println(incinum2);
		
		if(inciNum.equals(incinum2))
		{
			System.out.println("Incident number matches with the retrived number");
		} else {
			System.out.println("Incident number does not matches with the retrived number");
		}
		
	}
}