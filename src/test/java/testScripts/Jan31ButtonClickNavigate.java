package testScripts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Jan31ButtonClickNavigate {
  @Test
  public void buttonClickSample() throws InterruptedException {
	  WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/jqueryui/menu");
		driver.findElement(By.xpath("//a[text()='Enabled']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Downloads']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='CSV']")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Elemental Selenium")).click();
		//driver.findElement(By.partialLinkText("Elemental")).click(); instead of giving full name,by using  partialLinkText we can give partial name 
  }
  
}
