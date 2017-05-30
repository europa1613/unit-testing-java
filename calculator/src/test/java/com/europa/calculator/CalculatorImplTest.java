package com.europa.calculator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void addShouldReturnAResult() {
		ICalculator cal = new CalculatorImpl();
		int result = cal.add(10, 20);
		
		assertEquals(30, result);
	}

}
