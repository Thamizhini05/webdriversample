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
 


public class DataProviderMultipleSample {
	
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
  @Test(dataProvider="loginData")
  public void validLogin(String strname,String strPwd) {
	  driver.get(prop.getProperty("url"));
		//driver.get("https://the-internet.herokuapp.com/login");
		driver.findElement(By.id("username")).sendKeys(strname);
		driver.findElement(By.cssSelector("#password")).sendKeys(strPwd);
		driver.findElement(By.className("radius")).click();
		
		boolean isUserValid = driver.findElement(By.cssSelector("div.flash.success")).isDisplayed();
		Assert.assertTrue(isUserValid);
 
  }
  @DataProvider(name="loginData")
  public Object[][] getData() throws CsvValidationException, IOException{
	  String path=System.getProperty("user.dir")+
				"//src//test//resources//testData//loginData.csv";
	  CSVReader reader=new CSVReader(new FileReader(path));
	  String cols[];
	  ArrayList<Object> dataList=new ArrayList<Object>();
	  while((cols=reader.readNext())!=null) {
		  Object record[]= {cols[0],cols[1]};
		  dataList.add(record);
	  }
	  reader.close();
	  return dataList.toArray(new Object[dataList.size()][]);
	  
	  //.csv
	  
  }
  @AfterMethod
  public void teardown() {
	  driver.close();
  }
  
}
  