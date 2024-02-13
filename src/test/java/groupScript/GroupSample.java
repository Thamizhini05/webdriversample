/* 
 <groups>
	<run>
		<include name="feature1"/>
		<include name="feature2"/>
		<!--exclude is also available -->
	</run>
</groups>
  <test thread-count="5" name="ModuleTest">
    <classes>
	<class name="groupScript.FeatureSample"></class>
	<class name="groupScript.GroupSample"></class> 
  */


package groupScript;

import org.testng.annotations.Test;

public class GroupSample {
  @Test(groups="feature1")
  public void testOne() {
	  System.out.println("Test one in GroupSample");
  }
  @Test(groups="feature1")
  public void testSecond() {
	  System.out.println("Test two in GroupSample");
  }
  @Test(groups="feature2")
  public void testThird() {
	  System.out.println("Test three in GroupSample");
  }
  @Test
  public void testFourth() {
	  System.out.println("Test four in GroupSample");
  }
}


