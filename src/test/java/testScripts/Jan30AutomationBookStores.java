package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Jan30AutomationBookStores {
  @Test
  public void TextSampleMessage() throws InterruptedException {
	  WebDriver driver = new ChromeDriver();
	  driver.get("https://automationbookstore.dev/");
	  WebElement message = driver.findElement(By.id("searchBar"));
	  message.sendKeys("Test Automation");
	  Thread.sleep(2000);
	  WebElement hiddenIcon = driver.findElement(By.linkText("Clear text"));
	  //isDisplayed method
	  if(hiddenIcon.isDisplayed()){
		  hiddenIcon.click();
		  System.out.println("Text Cleared");
	  }
	  else {
		  System.out.println("Clear Icon Hidden");
	  }
	   }

	  }
	  
	 //input[place
