package testScripts;
import java.time.Duration;
 
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
 
public class feb2_ass_parasoft {
	WebDriver driver;
    @BeforeClass
  public void setup() throws Exception {
	  driver=new ChromeDriver();
	  driver.get("https://parabank.parasoft.com/parabank/register.htm");
  }
@Test
	 public void login() throws InterruptedException
	 {
		 WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
		  username.sendKeys("tamil");
		  WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
		  password.sendKeys("tamil@1234");
		  WebElement logBtn=driver.findElement(By.xpath("//input[@class='button']"));
		  logBtn.click();
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 Assert.assertEquals(driver.getTitle(),"ParaBank | Accounts Overview" );
	 }
	 
	 
  @Test(priority=1)
  public void openAccount() throws InterruptedException {
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  WebElement accountOpen = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Open New Account']")));
      accountOpen.click();
	  Select accountType=new Select(driver.findElement(By.id("type")));
	  accountType.selectByVisibleText("CHECKING");
	  wait.until(ExpectedConditions.elementToBeClickable(By.id("fromAccountId")));
	  Select accountNo=new Select(driver.findElement(By.id("fromAccountId")));
	  accountNo.selectByValue("13677");
	  WebElement openacc=driver.findElement(By.xpath("//input[@value='Open New Account']"));
	  openacc.click();
    boolean isValid=driver.findElement(By.xpath("//div[@class='ng-scope']//p[1]")).isDisplayed();
   	AssertJUnit.assertTrue(isValid);
    boolean isValid2=driver.findElement(By.xpath("//div[@class='ng-scope']//p[2]")).isDisplayed();
   	AssertJUnit.assertTrue(isValid2);
  }
  
  
  @Test(priority=2)
   	public void transferFunds() throws InterruptedException {
   	WebElement transferAmount=driver.findElement(By.xpath("//a[text()='Transfer Funds']"));
	  transferAmount.click();
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  WebElement amount=driver.findElement(By.xpath("//input[@id='amount']"));
	  amount.sendKeys("700");
	  wait.until(ExpectedConditions.presenceOfNestedElementsLocatedBy(By.xpath("//select[@id='fromAccountId']"), By.tagName("option")));
	  Select fromaccNo=new Select(driver.findElement(By.id("fromAccountId")));
	  fromaccNo.selectByValue("13677");
	  Select toaccNo=new Select(driver.findElement(By.id("toAccountId")));
	  toaccNo.selectByValue("13899");
	  WebElement tranBtn=driver.findElement(By.xpath("//input[@value='Transfer']"));
	  tranBtn.click();
	  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h1[text()='Transfer Complete!']"), "Transfer Complete!"));
	  boolean isValid3=driver.findElement(By.xpath("//h1[text()='Transfer Complete!']")).isDisplayed();
      AssertJUnit.assertTrue(isValid3);
   	}
   	
   	
  @Test(priority=3)
   	public void accOverview() throws InterruptedException {
     	WebElement accountOverview=driver.findElement(By.xpath("//a[text()='Accounts Overview']"));
  	  accountOverview.click();
   	}
  }
 
