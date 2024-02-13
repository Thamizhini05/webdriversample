package testScripts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Jan30SeleniumEasyDemo {
  @Test
  public void SeleniumDemoSample() { 
			  WebDriver driver = new ChromeDriver();
			  driver.get("https://demo.seleniumeasy.com/basic-first-form-demo.html");
			  WebElement message = driver.findElement(By.id("user-message"));
			  message.sendKeys("Demo Sample");
			  driver.findElement(By.xpath("//button[contains(text(),'Show Message')]")).click();
			  driver.findElement(By.id("value1")).sendKeys("10");
			  driver.findElement(By.id("value2")).sendKeys("20");
			  driver.findElement(By.xpath("//button[contains(text(),'Get Total')]")).click();		  
  }
}
