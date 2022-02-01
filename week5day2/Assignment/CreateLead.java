package week5day2.Assignment;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateLead extends BaseLead
{
	@BeforeClass
	public void setUp() {
		filename = "CLead";
	}	
	
	@Test(dataProvider = "fetchData")
	public void createLead(String cName, String fName, String lName) {
			    driver.findElement(By.linkText("Create Lead")).click();
				
				driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cName);
				driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
				driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
			    driver.findElement(By.className("smallSubmit")).click();
			   
			    String title = driver.getTitle();
			    System.out.println(title);
		}	
}
