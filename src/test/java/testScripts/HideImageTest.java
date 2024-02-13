package testScripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import java.util.HashMap;
public class HideImageTest {
  @Test
  public void hideImage() {
	  ChromeOptions options=new ChromeOptions();
	  //method 1 loading
	  //will disable the image
	  options.addArguments("--blink-setting=imagesEnabled=false");
	  //options.addArguments("--blink-setting=imagesEnabled=true");
	  //or alternatively we can set direct preference 
	  //method 2
	  /*
	  Map<String,Object> prefs=new HashMap<String,Object>();
	  prefs.put("profile.managed_default_contect_settings.images", 2);
	  options.setExperimentalOption("prefs", prefs);
	  WebDriver driver=new ChromeDriver(options);
	  driver.get("https://demo.opencart.com/");
	  */
  }
}
