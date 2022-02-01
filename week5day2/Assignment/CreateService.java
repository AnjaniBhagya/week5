package week5day2.Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateService extends BaseService 
{
	@BeforeClass
	public void setUp() {
		filename = "CreateService";
	}	
	@Test(dataProvider = "serviceData")
	public void createservice(String descript,String workNotes) throws InterruptedException 
	{
		driver.findElement(By.xpath("//div[@class='sn-widget-list-title' and text()='Create New'][1]/ancestor::a")).click();
		driver.switchTo().frame("gsft_main");		
		Thread.sleep(1000);
		driver.findElement(By.id("sys_display.incident.caller_id")).sendKeys("System Administrator",Keys.ENTER);
		Thread.sleep(1000);		

		driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys(descript,Keys.TAB);
		driver.findElement(By.id("incident.description")).sendKeys(workNotes,Keys.TAB);
		String inciNum = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
		System.out.println(inciNum);
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		Thread.sleep(1000);
	}

}
