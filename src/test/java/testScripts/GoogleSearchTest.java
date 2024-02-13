package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class GoogleSearchTest {
  @Test//annotations(read during the runtime)
  public void searchJavaTest() {
	    ChromeOptions options=new ChromeOptions();
		options.setBrowserVersion("115");
		WebDriver driver =new ChromeDriver(options);
		driver.get("https://www.google.com/");
		WebElement srcBox=driver.findElement(By.id("APjFqb"));
		srcBox.sendKeys("Java Tutorials");
		srcBox.sendKeys(Keys.ENTER);
		//srcBox.submit(Keys.ENTER);
  }
}
