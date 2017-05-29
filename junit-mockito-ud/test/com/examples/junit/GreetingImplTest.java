package com.examples.junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class GreetingImplTest {

	@Test
	public void greetShouldReturnAValidOutput() {
		IGreeting greeting = new GreetingImpl();
		String result = greeting.greet("JUnit");
		assertNotNull(result);
		assertEquals("Hello, JUnit", result);
	}

	@Test(expected = IllegalArgumentException.class)
	public void greetShouldThrowAnException_for_NameIsNull() {
		IGreeting greeting = new GreetingImpl();
		greeting.greet(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void greetShouldThrowAnException_for_NameIsBlank() {
		IGreeting greeting = new GreetingImpl();
		greeting.greet("");
	}

}
