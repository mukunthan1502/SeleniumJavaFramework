package demo;

import org.testng.annotations.Test;

@Test(groups = {"AllClassTest"})
public class TestNGGroupsDemo {
	
	@Test(groups= {"all.sanity"})
	public void test1() {
		System.out.println("test1");
	}
	
	@Test(groups = {"linux.sanity","linux.smoke","linux.regression","linux.integration"})
	public void test2() {
		System.out.println("test2");
	}
	
	@Test(groups = {"all.regression", "all.smoke"})
	public void test3() {
		System.out.println("test3");
	}
	
	@Test(groups = {"windows.regression"})
	public void test4() {
		System.out.println("test4");
	}
	
	@Test(groups = "all.acceptance")
	public void test5() {
		System.out.println("test5");
	}

	@Test(groups = "all.system")
	public void test6() {
		System.out.println("test6");
	}
	
	@Test(groups = "linux.acceptance, linux.system")
	public void test7() {
		System.out.println("test7");
	}



}
