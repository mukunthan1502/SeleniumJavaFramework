package demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import listeners.RetryAnalyzer;

public class TestNGRetryFailedDemo {
	
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void test1() {
		System.out.println("I am inside Test 1 ");
	}
	
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void test2() {
		System.out.println("I am inside Test 2 ");	
		int i=1/0;    //Supposedly triggered a failed
	}
	
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void test3() {
		System.out.println("I am inside Test 3 ");
		Assert.assertTrue(0>1);  //expression not true, step will fail
	}
}
