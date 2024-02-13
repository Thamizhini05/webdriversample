package testScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AutoCompleteSample {
  @Test
  public void autoComplete() {
	  WebDriver driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://jqueryui.com/autocomplete/");
	  WebElement frame1=driver.findElement(By.cssSelector(".demo-frame"));
	  driver.switchTo().frame(frame1);
	  WebElement inp=driver.findElement(By.cssSelector("#tags"));
	  inp.sendKeys("as");
	  List<WebElement> items =driver.findElements(By.cssSelector("ul#ui-id-1 > li"));
	  //to know the number of matching elements
	  System.out.println("Number of matching elements items...."+items.size());
	  //to get the text of each items
	  for(WebElement item : items) {
	  System.out.println(item.getText());
	  //to select the expected value
//	  if(item.getText().equalsIgnoreCase(expValue)) {
//		  item.click();
//			break;
//	  }
		  
	  }
  }
}
