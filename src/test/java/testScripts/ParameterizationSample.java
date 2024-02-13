package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class ParameterizationSample {
	
//	driver=new WebDriver("config.properties");  
//    
//    Properties p=new Properties();  
//    p.load(reader); 
//    System.out.println(p.getProperty("browser"));  
//    System.out.println(p.getProperty("url"));  
	WebDriver driver;
	@Parameters("browser")//parameters in testng
	  @BeforeMethod
  @Test
  public void setup(String strBrowser) {
		 
	  
	  System.out.println("Browser name..."+strBrowser);
	  if(strBrowser.equalsIgnoreCase("chrome")) {
		  driver=new ChromeDriver();
	  }
	  else if(strBrowser.equalsIgnoreCase("edge")) {
		  driver=new EdgeDriver();
	  }
	  
	  driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().deleteAllCookies();
	}
	  @Test
	  public void validLogin(String strBrowser) {
		
		driver.get("https://the-internet.herokuapp.com/login");
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.cssSelector(".fa.fa-2x.fa-sign-in")).click();
		boolean isUserValid =driver.findElement(By.cssSelector("div.flash.success")).isDisplayed();
		Assert.assertTrue(isUserValid);
  }
}
