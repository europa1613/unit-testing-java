package com.europa.calculator;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Steps for creating Parameterized Unit Tests 
 * 1. Identify input data and result
 * 2. create fields in the test class with above 
 * 3. create a constructor 
 * 4. create a static method return Collection (mark @Parameters) 
 * 5. create of update the test method
 * 6. Mark the test class @RunWith(Parameterized.class)
 * 
 * @author europa
 *
 */

@RunWith(Parameterized.class)
public class CalcParameterizedTest {

	private int num1, num2, result;

	public CalcParameterizedTest(int num1, int num2, int result) {
		this.num1 = num1;
		this.num2 = num2;
		this.result = result;
	}

	@Parameters
	public static Collection<Integer[]> dataSet() {
		return Arrays.asList(new Integer[][] { { -1, 2, 1 }, { 1, 2, 3 }, { 6, 7, 13 } }); // num1, num2, result
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void addShouldReturnAResult() {
		ICalculator cal = new CalculatorImpl();
		int result = cal.add(this.num1, this.num2);

		assertEquals(this.result, result);
	}

}
