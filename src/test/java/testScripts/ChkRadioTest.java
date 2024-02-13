package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ChkRadioTest {
  @Test
  public void CheckBoxRadioButton() {
	  WebDriver driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://demo.seleniumeasy.com/basic-checkbox-demo.html");
	  WebElement age=driver.findElement(By.id("isAgeSelected()"));
	  if(!age.isSelected()) {
		  age.click();
	  }
	  driver.findElement(By.xpath("(//input[@class='cb1-element'])[2]")).click();
	  //radio button
	  driver.get("https://demo.seleniumeasy.com/basic-checkbox-demo.html");
	  driver.findElement(By.xpath("//input[@values='5 - 15']")).click();
  }
}
