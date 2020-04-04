package demo;

import org.testng.annotations.Test;

public class TestNGDependencyDemo {
	
	
	
	@Test(groups = "office", dependsOnMethods = "test2", priority = 2)
	public void test1() {
		System.out.println("test1");
	}
	
	@Test (groups = "office", dependsOnMethods = "test4", priority = 2)
	public void test2() {
		System.out.println("test2");
	}

	@Test (groups = "home", dependsOnMethods = "test4", dependsOnGroups = "office", priority = 2)
	public void test3() {
		System.out.println("test3");
	}
	
	@Test (groups = "home", priority = 1)
	public void test4() {
		System.out.println("test4");
	}
	
}