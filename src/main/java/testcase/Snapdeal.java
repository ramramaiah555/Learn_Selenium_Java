package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Snapdeal {

	public static void main(String[] args) {

		ChromeDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Actions actions = new Actions(driver);
		try {
			// Navigate to Snapdeal
			driver.get("https://www.snapdeal.com/");
			// Wait for page load
			wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete'"));
			// Hover over Men's Fashion
			WebElement mensFashion = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=\"Men's Fashion\"]")));
			actions.moveToElement(mensFashion).perform();
			// Click on Sports Shoes
			WebElement sportsShoes = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Sports Shoes']")));
			sportsShoes.click();
			// Get sports shoes text
			String shoesText = driver
					.findElement(By.xpath("//div[text()='Sports Shoes for Men']/following-sibling::div")).getText();
			System.out.println(shoesText);
			// Click on Training Shoes
			WebElement trainingShoes = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Training Shoes']")));
			trainingShoes.click();
			// Hover over first shoe
			WebElement firstShoe = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.cssSelector("div[class$='favDp product-tuple-listing js-tuple ']")));
			actions.moveToElement(firstShoe).perform();
			// Click Quick View
			WebElement quickView = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//div[contains(@class,'clearfix row-disc')]//div[text()='Quick View']")));
			quickView.click();
		} finally {
			driver.quit();

		}
	}

}
