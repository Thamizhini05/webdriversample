package testScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class GooglePageTest {

	public static void main(String[] args) throws InterruptedException {
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://www.google.com");
//		WebDriver driver= new EdgeDriver();
		
//		ChromeOptions options=new ChromeOptions();
//		options.setBrowserVersion("115");
//		WebDriver driver =new ChromeDriver(options);
//		driver.get("https://www.google.com/");
//		WebElement srcBox=driver.findElement(By.id("APjFqb"));
//		srcBox.sendKeys("Java Tutorials");
//		srcBox.sendKeys(Keys.ENTER);
		
		/*
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://www.google.com");
		 driver.navigate().to("https://www.google.com/");
		 WebElement srcBox=driver.findElement(By.id("APjFqb"));
		 srcBox.sendKeys("Java Tutorials");
		srcBox.sendKeys(Keys.ENTER);
		System.out.println("Before click back...Page Title:....."+ driver.getTitle());//getTitle introgation method
		driver.navigate().back();
		System.out.println("After click ...Page Title:....."+ driver.getTitle());
		driver.navigate().forward();
		System.out.println("URL...."+driver.getCurrentUrl()); 
		*/
		
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.google.com/");
		WebElement srcBox=driver.findElement(By.id("APjFqb"));
		srcBox.sendKeys("Java Tutorials");
		Thread.sleep(1000);
		List<WebElement> items=driver.findElements(By.xpath("(//ul[@class='G43f7e'])[1]//li//descendant::div[@class='InnVSe']"));
		System.out.println("No.of items...."+items.size());
		for(WebElement item:items) {
			System.out.println(item.getText());
			if(item.getText().equalsIgnoreCase("java tutorial pdf")) {
				item.click();
				break;
			}
		}
	}

}
