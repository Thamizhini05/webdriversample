//group is used to separate a huge methods to a selected one
//include and exclude is used
//should mention in testng.xml and run that file as 'TestNG Suite'


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

public class FeatureSample {
	  @Test
	  public void testOne() {
		  System.out.println("Test one in FeatureSample");
	  }
	  @Test
	  public void testSecond() {
		  System.out.println("Test two in FeatureSample");
	  }
	  @Test(groups="feature2")
	  public void testThird() {
		  System.out.println("Test three in FeatureSample");
	  }
	  @Test
	  public void testFourth() {
		  System.out.println("Test four in FeatureSample");
	  }
}
