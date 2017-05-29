package com.examples.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GreetingImplTest {

	private IGreeting greeting;

	@Before
	public void setup() {
		System.out.println("setup");
		greeting = new GreetingImpl();
	}

	@Test
	public void greetShouldReturnAValidOutput() {
		System.out.println("greetShouldReturnAValidOutput");
		String result = greeting.greet("JUnit");
		assertNotNull(result);
		assertEquals("Hello, JUnit", result);
	}

	@Test(expected = IllegalArgumentException.class)
	public void greetShouldThrowAnException_for_NameIsNull() {
		System.out.println("greetShouldThrowAnException_for_NameIsNull");
		greeting.greet(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void greetShouldThrowAnException_for_NameIsBlank() {
		System.out.println("greetShouldThrowAnException_for_NameIsBlank");
		greeting.greet("");
	}
	
	@After
	public void teardown() {
		System.out.println("teardown");
		greeting = null;
	}

}