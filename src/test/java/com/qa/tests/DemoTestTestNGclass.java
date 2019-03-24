package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTestTestNGclass {
	
	@Test
	public void sum() {
		System.out.println("SUM 1 "); 
		int a=10;
		int b =20;
		Assert.assertEquals(30, a+b);
	}

	@Test
	public void div() {
		System.out.println("Division"); 
		int a=10;
		int b =20;
		Assert.assertEquals(2, b/a);
	}

	@Test
	public void mult() {
		System.out.println("Multiply "); 
		int a=10;
		int b =20;
		Assert.assertEquals(200, a*b);
	}

	@Test
	public void diff() {
		System.out.println("Diff"); 
		int a=10;
		int b =20;
		Assert.assertEquals(10, b-a);
	}

	
}
