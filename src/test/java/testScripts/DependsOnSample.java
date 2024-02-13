package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DependsOnSample {
	
WebDriver driver;
	
	@BeforeMethod
	//@BeforeTest
	public void setup() {
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	@Test(dependsOnMethods="searchSeleniumTest")
	  public void searchJavaTest() throws InterruptedException {
		  driver.get("https://www.google.com");
		  //Assert.assertEquals(driver.getTitle(),"Google Page");
		  SoftAssert softAssert =new SoftAssert();
		  softAssert.assertEquals(driver.getTitle(),"Google");
		  WebElement srcBox =driver.findElement(By.id("APjFqb"));
		  srcBox.sendKeys("Java Tutorial");
		  srcBox.submit();
		  softAssert.assertEquals(driver.getTitle(), "Google");
		  softAssert.assertAll();
	  }
	  
	  @Test 
	  public void searchSeleniumTest() throws InterruptedException {
		  driver.get("https://www.google.com");
		  WebElement srcBox =driver.findElement(By.id("APjFqb"));
		  srcBox.sendKeys("Selenium Tutorial");
		  Assert.assertEquals(driver.getTitle(), "Google Search");
	  }
	  
	  @AfterMethod
	  //@AfterTest
	  public void closeMethod() {
		  driver.close();
	  }
	  
}
