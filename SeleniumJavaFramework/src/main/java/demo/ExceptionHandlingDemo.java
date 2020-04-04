package demo;

public class ExceptionHandlingDemo {

	public static void main(String[] args) {
		
		try {
			System.out.println("Inside Try");
			demo();
		}
		catch(Exception exp) {
			System.out.println("Inside Catch");
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		finally {
			System.out.println("Inside Finally");
		}


	}
	
	public static void demo() throws Exception {
		System.out.println("Hello World...!");
		int i =1/0;
		System.out.println("Completed");
		System.out.println("After exception in function");
	}

}
