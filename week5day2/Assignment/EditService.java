package week5day2.Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EditService extends BaseService
{
	@BeforeClass
	public void setUp() {
		filename = "EditService";
	}	
	@Test(dataProvider = "serviceData")
	public void editservice(String oldDescript,String descript,String workNotes) throws InterruptedException
	{
		driver.findElement(By.xpath("(//div[@class='sn-widget-list-title' and text()='Open'][1]/ancestor::a)[1]")).click();
		driver.switchTo().frame("gsft_main");		
		Thread.sleep(1000);
		
		Select dd1 = new Select(driver.findElement(By.xpath("(//label[text()='Search'])[1]/preceding-sibling::select")));
		dd1.selectByValue("caller_id");
		Thread.sleep(1000);		
		driver.findElement(By.xpath("(//label[text()='Search'])[2]/following-sibling::input")).sendKeys("System Administrator",Keys.ENTER);
		Thread.sleep(1000);
		
		Select dd2 = new Select(driver.findElement(By.xpath("(//label[text()='Search'])[1]/preceding-sibling::select")));
		dd2.selectByValue("short_description");
		Thread.sleep(1000);		
		driver.findElement(By.xpath("(//label[text()='Search'])[2]/following-sibling::input")).sendKeys(oldDescript,Keys.ENTER);
		Thread.sleep(1000);
		
		String numinci = driver.findElement(By.xpath("//table[@id='incident_table']//tr[1]/td[3]/a[1]")).getText();
		System.out.println(numinci);
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//span[@data-original-title='Search']")).click();
		driver.findElement(By.id("sysparm_search")).sendKeys(numinci,Keys.ENTER);
		Thread.sleep(500);
		
		driver.switchTo().frame("gsft_main");	
		Thread.sleep(500);
		//String sdtext = driver.findElement(By.id("incident.short_description")).getText();
		String text = driver.findElement(By.xpath("//span[@id='status.incident.short_description']/following-sibling::span")).getText();
		System.out.println(text);
		
		  driver.findElement(By.id("incident.short_description")).sendKeys(descript,Keys.TAB);
		 driver.findElement(By.id("incident.description")).sendKeys(workNotes,Keys.TAB); 
		 driver.findElement(By.id("sysverb_update_bottom")).click(); 
		 }
		 


}
