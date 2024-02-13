package testScripts;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	private int retryCount=0;
	private static final int maxretryCount=3;
	public boolean retry(ITestResult result) {
		if(!result.isSuccess()){
	    if (retryCount < maxretryCount) {
	      retryCount++;
	      return true;
	    }
		}
	    return false;
	  }

}
