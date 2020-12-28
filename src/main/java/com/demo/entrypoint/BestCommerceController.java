package com.demo.entrypoint;

public class BestCommerceController {
	
	public String methodA() {
		System.out.println("Method A activated!");
		return "Method A!";
	}
	
	public void methodB() {
		System.out.println("Method B activated!");
	}
	
	public String methodC(String inputA, String inputB) {
		System.out.println("Method C activated!");
		return "Method C got " + inputA + " and " + inputB;
	}

}
