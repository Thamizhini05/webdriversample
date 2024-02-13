//if priority is not given, then it will execute in alphabetical order
//if for some test the priority is given and remaining some test if priority is not given then,
//the elements without priority will execute first and the mentioned priority will be executed.

package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleSearchScenarios {
  @Test
  public void searchSeleniumTest() throws InterruptedException {
	  WebDriver driver =new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	  driver.get("https://www.google.com");
	  WebElement srcBox =driver.findElement(By.id("APjFqb"));
	  srcBox.sendKeys("Selenium Tutorial");
	  Assert.assertEquals(driver.getTitle(), "Google");
  }
  
  @Test
  public void searchCucumber() throws InterruptedException {
	  WebDriver driver =new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	  driver.get("https://www.google.com");
	  WebElement srcBox =driver.findElement(By.id("APjFqb"));
	  srcBox.sendKeys("Cucumber Tutorial");
	  Assert.assertEquals(driver.getTitle(), "Google");
  }
  
  @Test
  public void searchJavaTest() throws InterruptedException {
	  WebDriver driver =new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	  driver.get("https://www.google.com");
	  WebElement srcBox =driver.findElement(By.id("APjFqb"));
	  srcBox.sendKeys("Java Tutorial");
	  Assert.assertEquals(driver.getTitle(), "Google");
  }
  
  @Test
  public void searchAppiumTest() throws InterruptedException {
	  WebDriver driver =new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	  driver.get("https://www.google.com");
	  WebElement srcBox =driver.findElement(By.id("APjFqb"));
	  srcBox.sendKeys("Appium Tutorial");
	  Assert.assertEquals(driver.getTitle(), "Google");
  }
}
