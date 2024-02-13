package testScripts;
 
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
 


public class DataProviderSample {
	
	WebDriver driver;
	Properties prop;
	@Parameters("browser") //parameters should be imported from test ng
	@BeforeMethod
	public void setup() throws IOException {
		String path = System.getProperty("user.dir")+
				"//src//test//resources//configFiles//config.properties";
		FileInputStream fin = new FileInputStream(path);
		prop = new Properties();
		prop.load(fin);
		String strBrowser1=prop.getProperty("browser");
		System.out.println("Browser name...."+strBrowser1);
		if(strBrowser1.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		
		else
			if(strBrowser1.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
			
	}
  @Test
  public void validLogin() {
	  driver.get(prop.getProperty("url"));
		//driver.get("https://the-internet.herokuapp.com/login");
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.cssSelector("#password")).sendKeys("SuperSecretPassword!");;
		driver.findElement(By.className("radius")).click();
		
		boolean isUserValid = driver.findElement(By.cssSelector("div.flash.success")).isDisplayed();
		Assert.assertTrue(isUserValid);
 
  }

  @AfterMethod
  public void teardown() {
	  driver.close();
  }
  
}
  