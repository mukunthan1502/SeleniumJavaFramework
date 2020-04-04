package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	private int retryCounter = 0;
	private static int max_Attempts = 3;
	@Override
	public boolean retry(ITestResult result) {
		while(retryCounter<max_Attempts) {
			System.out.println("Attempt: " +(retryCounter+1));
			retryCounter++;
			return true;
		}
		return false;
	}
}
