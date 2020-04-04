package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {
	
	//Invoked each time before a test will be invoked.
	public void onTestStart(ITestResult result) {
		System.out.println("******** Test started: " +result.getName());
	}
	
	
	//Invoked each time a test succeeds.
	public void onTestSuccess(ITestResult result) {
		System.out.println("******** Test success: " +result.getName());
	}
	
	
	//Invoked each time a test fails.
	public void onTestFailure(ITestResult result) {
		System.out.println("******** Test failed:  " +result.getName());
	}
	
	
	//Invoked each time a test is skipped.
	public void onTestSkipped(ITestResult result) {
		System.out.println("******** Test skipped: " +result.getName());
	}
	
	
	//Invoked after all the tests have run and all their Configuration methods have been called.
	public void onFinish(ITestContext context) {
		System.out.println("******** Test Completed: " +context.getName());
	}
	
	
	//Invoked each time a method fails but has been annotated with successPercentage and this failure still keeps it within the success percentage requested.
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("******** Test failed but within success percentage: " +result.getName());
	}
	
	
	//Invoked after the test class is instantiated and before any configuration method is called.
	public void onStart(ITestContext context) {
		System.out.println("******** Test Class Start: " +context.getName());
	}
}

