/*
 types : by index,by name or id and by web element
To find iFrame:
	WebElement iFrame=driver.findElement(By.tagName("iframe"));
	driver.switchTo().frame(1);//index
	driver.switchTo().frame(frameName);//name
	driver.switchTo().frame(iFrame);//web element
 
 */
package testScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class IframesSample {
  @Test
  public void iFramesSample() {
	  	WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		//from main page to frame 1
		driver.switchTo().frame("frame1");
		WebElement inpBox=driver.findElement(By.xpath("//input[@type='text']"));
		inpBox.sendKeys("Hello Welcome");
		//from frame 1 to frame 3 in the page by inspect
		driver.switchTo().frame("frame3");
		WebElement ifram1=driver.findElement(By.xpath("//input[@id='a']"));
		//driver.findElement(By.id("a")).click();
		ifram1.click();
		//select the particular name from the drop down
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame2");
		Select selEle = new Select (driver.findElement(By.cssSelector("select#animals")));
		selEle.selectByVisibleText("Big Baby Cat");
		List<WebElement> names=selEle.getAllSelectedOptions();
		  for(WebElement list:names)
		  {
			  System.out.println(list.getText());
		  }
  }
}

