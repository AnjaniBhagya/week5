package week5day2.Assignment;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EditLead extends BaseLead {
	@BeforeClass
	public void setUp() {
		filename = "CLead";
	}	
	
	@Test(dataProvider = "fetchData")
	public void editlead(String cName, String fName, String lName)
	{
		 driver.findElement(By.linkText("Find Leads")).click();
		   driver.findElement(By.xpath("//span[contains(text(),'Name and ID')]/ancestor::a")).click();
		   driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys(fName);
		   driver.findElement(By.xpath("//button[text()='Find Leads']")).click(); 
		   try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		   driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[@class='linktext'])[1]")).click();
		   String title1 = driver.getTitle();
		   System.out.println("The Page Title is: "+title1);
		    driver.findElement(By.xpath("//a[@class='subMenuButton' and contains(text(),'Edit') ]")).click();
		    System.out.println("We are in Edit Page .");		    
		    driver.findElement(By.id("updateLeadForm_firstNameLocal")).clear();
		    driver.findElement(By.id("updateLeadForm_firstNameLocal")).sendKeys(fName);
		    
		    driver.findElement(By.id("updateLeadForm_lastNameLocal")).clear();
		    driver.findElement(By.id("updateLeadForm_lastNameLocal")).sendKeys(lName);
		    driver.findElement(By.xpath("//input[@value=\"Update\" and @type='submit']")).click();
		    
	}

}
