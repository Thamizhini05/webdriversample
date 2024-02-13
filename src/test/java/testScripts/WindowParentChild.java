package testScripts;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowParentChild {
  @Test
  public void windowFumctionsCloseQuit() {
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
		driver.close();//it 
		driver.switchTo().window(parentWin);
		driver.findElement(By.xpath("//button[contains(text(),'new Window')]")).click();
		
		// to handle windows in new browser in new browser window
		Set<String> wins=driver.getWindowHandles();
		System.out.println("Number of windows:"+wins.size());
		for(String childWin:wins) {
			System.out.println(childWin);
			if(!childWin.equalsIgnoreCase(parentWin)) {
				driver.switchTo().window(childWin);
			}
		}
		//driver.close();//close method is used to close only the mentioned window like child...
		//driver.close();
		driver.quit();//quit method is used to close all the window of the current driver
		//rem....once we close a window we have to navigate it back to the parent window
				}
}
