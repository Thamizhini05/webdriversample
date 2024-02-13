package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;


public class Jan31StudentRegistrationPage {
  @Test
  public void diffFunctionsOfForm() throws InterruptedException {
	  WebDriver driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://demoqa.com/automation-practice-form");
	  //firstname
	  WebElement firstName=driver.findElement(By.id("firstName"));
	  firstName.sendKeys("Thamizhini");
	  //last name
	  WebElement lastName=driver.findElement(By.id("lastName"));
	  lastName.sendKeys("K A");
	  //mail id
	  WebElement emailId=driver.findElement(By.id("userEmail"));
	  emailId.sendKeys("thamizhini1302@gmail.com");
	  //gender(radio button)
	  driver.findElement(By.xpath("//label[@class='custom-control-label'][contains(text(), 'Female')]")).click();
	  //phone number
	  WebElement numberBox= driver.findElement(By.cssSelector("input#userNumber"));
	  numberBox.sendKeys("8967895648");
	  Thread.sleep(1000);
	  
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  WebElement date=(WebElement)js.executeScript("return document.getElementById('dateOfBirthInput').value='05 Mar 2024'");
//	  
	  
	  WebElement textArea=driver.findElement(By.xpath("//input[@id='subjectsInput']"));
	  textArea.sendKeys("This is the form");
	  Thread.sleep(1000);
	  WebElement sports=driver.findElement(By.xpath("//label[text()='Sports']"));
	  sports.click();
	  
	  WebElement sub = driver.findElement(By.xpath("//input[@id='subjectsInput']"));
	  sub.sendKeys("hi");
	  
	  //upload image
	  WebElement pictureBox= driver.findElement(By.cssSelector("input#uploadPicture"));
	  String strPath = System.getProperty("user.dir")+"//Screenshot (1).png";
	  pictureBox.sendKeys(strPath);
	  
	  WebElement curAddress=driver.findElement(By.id("currentAddress"));
	  curAddress.sendKeys("abcdefgh");
  }
}


