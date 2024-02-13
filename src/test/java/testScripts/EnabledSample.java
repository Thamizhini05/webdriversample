//if enable is given as false it will not execute.
//by default it is true

package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EnabledSample {
  @Test
  public void searchSeleniumTest() throws InterruptedException {
	  WebDriver driver =new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	  driver.get("https://www.google.com");
	  WebElement srcBox =driver.findElement(By.id("APjFqb"));
	  srcBox.sendKeys("Selenium Tutorial");
	  Assert.assertEquals(driver.getTitle(), "Google");
  }
  
  @Test(enabled=false)//it will not excuete
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
