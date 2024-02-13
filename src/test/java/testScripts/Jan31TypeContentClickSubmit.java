package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Jan31TypeContentClickSubmit {
  @Test
  public void typeAndSubmit() throws InterruptedException {
	  WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/iframe");
		driver.switchTo().frame("mce_0_ifr");//to switch ti the frame
		driver.findElement(By.tagName("p")).sendKeys("The content is typed in the page.");//the text name is in paragraph
		Thread.sleep(1000);//to take time to see and navigate to the page
		driver.switchTo().defaultContent();//the default content of the page
		driver.findElement(By.linkText("Powered by Tiny")).click();// to navigate to the next page

		
  }
}
 