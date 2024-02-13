package parallelScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ParallelSample { 
	WebDriver driver;
  @Test
  public void testOne() {
	  driver=new ChromeDriver();
	  long id=Thread.currentThread().getId();
	  System.out.println("Test1 in ParallelSample..."+id);
  }
  @Test
  public void testSecond() {
	  driver=new ChromeDriver();
	  long id=Thread.currentThread().getId();
	  System.out.println("Test2 in ParallelSample..."+id);
  }
  @Test
  public void testThird() {
	  driver=new ChromeDriver();
	  long id=Thread.currentThread().getId();
	  System.out.println("Test3 in ParallelSample..."+id);
  }
  @Test
  public void testFourth() {
	  driver=new ChromeDriver();
	  long id=Thread.currentThread().getId();
	  System.out.println("Test4 in ParallelSample..."+id);
  }
}
