package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseOver {
  @Test
  public void mouseFunctions() throws InterruptedException {
	  WebDriver driver = new ChromeDriver();
	  Actions actions=new Actions(driver);
	  driver.manage().window().maximize();
	  //driver.get("https://demo.opencart.com/");
//	  driver.get("https://automationbookstore.dev/");
//	  WebElement srcBox=driver.findElement(By.id("searchBar"));
	  
	  //context click
//	  actions.contextClick(srcBox).perform();
	  //mouse actions
	  //WebElement menu =driver.findElement(By.cssSelector("ul.nav.navbar-nav li.dropdown:nth-child(3)"));
	  
	  //click,double click,multiple click
//	  driver.get("https://stqatools.com/demo/DoubleClick.php");
//	  Thread.sleep(2000);
//	  WebElement btn=driver.findElement(By.xpath("//button[text()='Click Me/ Double Click Me!']"));
//	  actions.doubleClick(btn).perform();
//	  actions.doubleClick(btn).doubleClick(btn).build().perform();
	  
	  
	  //mousehover actions
	  driver.get("https://stqatools.com/demo/MouseHover.php");
	  WebElement menu=driver.findElement(By.cssSelector("button.dropbtn"));
	  actions.moveToElement(menu).perform();
	  WebElement menuItem=driver.findElement(By.cssSelector("div.dropdown-content > a:nth-child(1)"));
	  actions.moveToElement(menu).click(menuItem).build().perform();
  }
}
