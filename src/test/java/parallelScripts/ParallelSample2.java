package parallelScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ParallelSample2 {
	WebDriver driver;
  @Test
  public void testOne() {
	  driver=new ChromeDriver();
	  long id=Thread.currentThread().getId();
	  System.out.println("Test1 in ParallelSample2..."+id);
  }
  @Test
  public void testSecond() {
	  driver=new ChromeDriver();
	  long id=Thread.currentThread().getId();
	  System.out.println("Test1 in ParallelSample2..."+id);
  }
  @Test
  public void testThird() {
	  driver=new ChromeDriver();
	  long id=Thread.currentThread().getId();
	  System.out.println("Test1 in ParallelSample2..."+id);
  }
  @Test
  public void testFourth() {
	  driver=new ChromeDriver();
	  long id=Thread.currentThread().getId();
	  System.out.println("Test1 in ParallelSample2..."+id);
  }
}
