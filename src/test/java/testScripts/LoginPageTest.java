package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class LoginPageTest {
  @Test
  public void f() {
//		WebDriver driver =new ChromeDriver();
//		driver.get("https://the-internet.herokuapp.com/login");
//		WebElement username=driver.findElement(By.id("username"));
//		username.sendKeys("tomsmith");
//		WebElement password=driver.findElement(By.id("password"));
//		password.sendKeys("SuperSecretPassword!");
//		WebElement loginButton=driver.findElement(By.className("radius"));
//		loginButton.click();
	
	  
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/login");
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		//driver.findElement(By.className("radius")).click();
		//driver.findElement(By.tagName("button")).click();
		//driver.findElement(By.tagName("button1")).click(); throws exception of NoSuchElementException
		 //css selector
		//driver.findElement(By.cssSelector("nav div.header__menu__items"));
		//driver.findElement(By.cssSelector("nav div.header__menu__items > div:nth-child(2)")).click();
		 driver.findElement(By.cssSelector("button.radius")).click();
		 driver.findElement(By.cssSelector(".radius")).click();
		 driver.findElement(By.cssSelector(".fa.fa-2x.fa-sign-in")).click();
		driver.findElement(By.linkText("Elemental Selenium")).click();
		driver.findElement(By.partialLinkText("Elemental")).click();
		
		
		
	
  }
}
/*
findElement();
used to locate single element and return web element object of first occurence
findElements():
used to locate more elements and return the elements based on the condition of the loop
*/

