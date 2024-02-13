package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import commonUtlis.Utility;

public class SampleOneTest {
	WebDriver driver;
	ExtentReports extentsReports;
	ExtentSparkReporter  spark;
	ExtentTest extentTest;
	
	@BeforeTest
	public void setupExtent() {
		extentsReports =new ExtentReports();
		spark=new ExtentSparkReporter("test-output/SparkReport.html")
				.viewConfigurer()
				.viewOrder()
				.as(new ViewName[] {
			ViewName.DASHBOARD,
			ViewName.TEST,
			ViewName.AUTHOR,
			ViewName.DEVICE,
			ViewName.LOG
		}).apply();
		extentsReports.attachReporter(spark);
		
	}
	@BeforeMethod
	//@BeforeTest
	public void setup() {
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
  @Test(retryAnalyzer=RetryAnalyzer.class)
  //(alwaysRun=true,dependsOnMethods="searchSeleniumTest")
  public void searchJavaTest() throws InterruptedException {
	  extentTest=extentsReports.createTest("Java Search Test");
	  driver.get("https://www.google.com");
	  //Assert.assertEquals(driver.getTitle(),"Google Page");
	  SoftAssert softAssert =new SoftAssert();
	  softAssert.assertEquals(driver.getTitle(),"Google Page");
	  WebElement srcBox =driver.findElement(By.id("APjFqb"));
	  srcBox.sendKeys("Java Tutorial");
	  srcBox.submit();
	  softAssert.assertEquals(driver.getTitle(), "Google");
	  softAssert.assertAll();
  }
  
  @Test 
  public void searchSeleniumTest() throws InterruptedException {
	  extentTest=extentsReports.createTest("Selenium Search Test");
	  driver.get("https://www.google.com");
	  WebElement srcBox =driver.findElement(By.id("APjFqb"));
	  srcBox.sendKeys("Selenium Tutorial");
	  Assert.assertEquals(driver.getTitle(), "Google");
	  System.out.println("Selenium Test");
  }
  
  @AfterMethod
  //@AfterTest
//  public void closeMethod() {
//	  driver.close();
//  }
  public void teardown(ITestResult result) {
	  extentTest.assignAuthor("AutomationTester1")
	  .assignCategory("Regression")
	  .assignDevice(System.getProperty("os.name"))
	  .assignDevice(System.getProperty("os.version"));
	  if(ITestResult.FAILURE==result.getStatus()) {
		  extentTest.log(Status.FAIL, result.getThrowable().getMessage());
		  String strPath=Utility.getScreenshotPath(driver);
		  extentTest.fail(MediaEntityBuilder.createScreenCaptureFromPath(strPath).build());
	  }
	  else if(ITestResult.SKIP==result.getStatus())
	  {
		  extentTest.log(Status.SKIP,result.getThrowable().getMessage());
	  }
	  driver.close();
  }
  @AfterTest
  public void finishExtent() {
	  extentsReports.flush();
  }
  
}
