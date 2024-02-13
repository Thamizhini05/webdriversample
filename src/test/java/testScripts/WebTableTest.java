package testScripts;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class WebTableTest {
  @Test
  public void searchEmpDetails() {
	  WebDriver driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://demo.seleniumeasy.com/table-sort-search-demo.html");
	  List<WebElement> items=driver.findElements(By.xpath("//td[text()='B. Wagner']//following-sibling::td"));
	  System.out.println("Number of items..."+items.size());
	  for(WebElement elem:items) {
		  System.out.println(elem.getText());
	  }
	  //To get the salary of an employee
	  System.out.println("The Salary of an Employee");
	  String strSalary=driver.findElement(By.xpath("\n"+"//td[text()='B. Wagner']//following-sibling::td[5]")).getText();
	  System.out.println(strSalary);
	  
//	  String strSalary1=driver.findElement(By.xpath("\n"+"//tr[text()='B. Wagner']//following-sibling::td[5]")).getText();
//	  System.out.println(strSalary1);
	 
	  List<WebElement> count=driver.findElements(By.xpath("//td[contains(text(),'San Francisco')]//preceding-sibling::td[2]"));
	  System.out.println("Number of items..."+count.size());
	  for(WebElement elem:count) {
		  System.out.println(elem.getText());
	  }
	  
	   }
}
