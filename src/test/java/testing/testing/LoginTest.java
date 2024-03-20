package testing.testing;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class LoginTest {

	
	public static void main(String[] args) {
		
		String uname = "student";
		String pword = "Password123";
		String expectedresult = "Logged In Successfully";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		
		
		WebElement userName = driver.findElement(By.id("username"));
		WebElement passWord = driver.findElement(By.id("password"));
		WebElement submitBtn = driver.findElement(By.id("submit"));
		
		userName.sendKeys(uname);
		passWord.sendKeys(pword);
		submitBtn.click();
		String actualresult = driver.findElement(By.cssSelector("h1[class='post-title']")).getText();
		Assert.assertEquals(actualresult,expectedresult);
		System.out.println("Actual Result: " + actualresult);
		System.out.println("Expected Result: " + expectedresult);
		if(expectedresult.equals(actualresult)) {
			System.out.println("PASSED"); 
		} else {
			System.out.println("FAILED"); 
		}
	}

}
