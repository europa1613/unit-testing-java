package com.examples.junit;

public class GreetingImpl implements IGreeting {

	@Override
	public String greet(String name) {
		return "Hello, " + name;
	}

}
