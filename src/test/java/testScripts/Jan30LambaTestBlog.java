package testScripts;
import java.util.List;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class Jan30LambaTestBlog {
  @Test
  public void playRight() {
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.lambdatest.com/blog/");
	  //index have been used here,but not all time it matches the index value.
	  //List<WebElement> item1 = driver.findElements(By.xpath("//ul[@id='menu-side-menu']//li[starts-with(@id,'menu-item-')][14]//preceding-sibling::li"));
	  List<WebElement> item1 = driver.findElements(By.xpath("//ul[@id='menu-side-menu']//li[.//a[text()='Playwright Testing']]/preceding-sibling::li"));
	  System.out.println("Preceding list to Playwright testing");
	  for(WebElement list:item1){
		  System.out.println(list.getText());
	  }
	  //List<WebElement> item2 = driver.findElements(By.xpath("//ul[@id='menu-side-menu']//li[starts-with(@id,'menu-item-')][14]//following-sibling::li"));
	  List<WebElement> item2 = driver.findElements(By.xpath("ul[@id='menu-side-menu']//li[.//a[text()='Playwright Testing']]/following-sibling::li"));
	  System.out.println("\nSucceeding list to Playwright testing");
	  for(WebElement list:item2){
		  System.out.println(list.getText());
	  }
				 
  }
}
	    
	  
	  
	  
	  
	  
	  