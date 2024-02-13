package testScripts;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.annotations.Test;
 
public class feb5_demoblaze_loginVerification {
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		driver =new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void loginsetup()
	{ 
	     driver.get("https://www.demoblaze.com/");
         WebElement login=driver.findElement(By.xpath("//a[text()='Log in']"));
		 login.click();
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	}
	
	@Test(priority=1)
	 public void usernameIncorrectTest() throws InterruptedException 
	 {
 
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		 WebElement usrname = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='loginusername']")));
		 usrname.sendKeys("thamil");
		 WebElement pswd=driver.findElement(By.xpath("//input[@id='loginpassword']"));
		 pswd.sendKeys("tamil123tamil");
		 WebElement loginBtn=driver.findElement(By.xpath("//button[text()='Log in']"));
		 loginBtn.click();
		 wait.until(ExpectedConditions.alertIsPresent());
		 Alert alert=driver.switchTo().alert(); 
		 Assert.assertEquals(alert.getText(), "Wrong password.");
		 alert.accept();
	 }
	
	@Test(priority=2)
	 public void passwordIncorrectTest() throws InterruptedException{
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		 WebElement usrname = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='loginusername']")));
		 usrname.sendKeys("Tamil K A");
		 WebElement pswd=driver.findElement(By.xpath("//input[@id='loginpassword']"));
		 pswd.sendKeys("tamil");
		 WebElement loginBtn=driver.findElement(By.xpath("//button[text()='Log in']"));
		 loginBtn.click();
		 wait.until(ExpectedConditions.alertIsPresent());
		 Alert alert=driver.switchTo().alert();
		 Assert.assertEquals(alert.getText(), "Wrong password.");
		 alert.accept();
	}
 
	@Test(priority=3)
	 public void passwordEmptyTest() throws InterruptedException
	 {
 
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		 WebElement usrname = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='loginusername']")));
		 usrname.sendKeys("Thamizhini Athiappan");
		 WebElement loginBtn=driver.findElement(By.xpath("//button[text()='Log in']"));
		 loginBtn.click();
		 wait.until(ExpectedConditions.alertIsPresent());	 
		 Alert alert=driver.switchTo().alert();
		 Assert.assertEquals(alert.getText(), "Please fill out Username and Password.");
		 alert.accept();
		 }
	
	@Test(priority=4)
	 public void usernameEmptyTest() throws InterruptedException
	 {
 
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		 WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='loginpassword']")));
		 password.sendKeys("1234tamil");
		 WebElement loginBtn=driver.findElement(By.xpath("//button[text()='Log in']"));
		 loginBtn.click();
		 wait.until(ExpectedConditions.alertIsPresent()); 
		 Alert alert=driver.switchTo().alert();
		 Assert.assertEquals(alert.getText(), "Please fill out Username and Password.");
		 alert.accept();
		 }
	
	@Test(priority=5)
	 public void usernamePasswordEmptyTest() throws InterruptedException
	 {
 
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		 WebElement usrname = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='loginusername']")));
		 usrname.sendKeys("");
		 WebElement pswd=driver.findElement(By.xpath("//input[@id='loginpassword']"));
		 pswd.sendKeys("");
		 WebElement loginBtn=driver.findElement(By.xpath("//button[text()='Log in']"));
		 loginBtn.click();
	     wait.until(ExpectedConditions.alertIsPresent()); 
		 Alert alert=driver.switchTo().alert();
		 Assert.assertEquals(alert.getText(), "Please fill out Username and Password.");
		 alert.accept();
		 }
	
	@Test(priority=6)
	 public void emptyUsernameWrongPasswordTest() throws InterruptedException
	 {

		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		 WebElement usrname = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='loginusername']")));
		 usrname.sendKeys("");
		 WebElement pswd=driver.findElement(By.xpath("//input[@id='loginpassword']"));
		 pswd.sendKeys("vhbfvj");
		 WebElement loginBtn=driver.findElement(By.xpath("//button[text()='Log in']"));
		 loginBtn.click();
	     wait.until(ExpectedConditions.alertIsPresent());
		 Alert alert=driver.switchTo().alert();
		 Assert.assertEquals(alert.getText(), "Please fill out Username and Password.");
		 alert.accept();
		 }
	
	@Test(priority=7)
	 public void emptyPasswordWrongUsernameTest() throws InterruptedException
	 {

		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		 WebElement usrname = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='loginusername']")));
		 usrname.sendKeys("fdihgif");
		 WebElement pswd=driver.findElement(By.xpath("//input[@id='loginpassword']"));
		 pswd.sendKeys("");
		 WebElement loginBtn=driver.findElement(By.xpath("//button[text()='Log in']"));
		 loginBtn.click();
	     wait.until(ExpectedConditions.alertIsPresent());
		 Alert alert=driver.switchTo().alert();
		 Assert.assertEquals(alert.getText(), "Please fill out Username and Password.");
		 alert.accept();
		 driver.close();
		 }

}