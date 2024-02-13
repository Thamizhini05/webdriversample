//getWindowHandle,getWindowHandles(window handle will be unique string  for the 
 //                                  current browser on the windows on desktop)
package testScripts;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowsPopup {
  @Test
  public void windowSample() {
	  WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://stqatools.com/demo/Windows.php");
		String parentWin =driver.getWindowHandle();
		System.out.println("parent window handle:"+parentWin);
		driver.findElement(By.xpath("//button[contains(text(),'new Tab')]")).click();
		Set<String> tabs=driver.getWindowHandles();//set is used because it has 
		System.out.println("Number of windows:"+tabs.size());
		for (String childWin:tabs) {
			System.out.println(childWin);
			if(!childWin.equalsIgnoreCase(parentWin)) {
				driver.switchTo().window(childWin);
				driver.findElement(By.xpath("//a[contains(text(),'Java)]")).click();
			}
		}
		
  }
}
