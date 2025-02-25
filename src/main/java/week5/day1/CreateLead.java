package week5.day1;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CreateLead extends BaseClass {

	@Test
	public void runCreateLead() {

		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Qeagle");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Ramkumar");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Ramaiah");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("9750");
		driver.findElement(By.name("submitButton")).click();
		String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if (text.contains("Qeagle")) {
			System.out.println("Lead created successfully");
		} else {
			System.out.println("Lead is not created");
		}

		leadID = text.replaceAll("\\D", "");
		System.out.println("Lead ID : " + leadID);

	}

}
