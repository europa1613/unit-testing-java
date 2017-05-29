package com.mockito.scrapbook;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ATest {

	@Mock
	B b;

	A a;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		a = new A(b);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void usesVoidMethodShouldCall_BVoidMethod() throws Exception {
		doNothing().when(b).voidMethod();
		assertEquals(0, a.usesVoidMethod());
		verify(b, times(1)).voidMethod();
	}

	@Test(expected = RuntimeException.class)
	public void usesVoidMethod_should_throw_RuntimeException() throws Exception {
		doThrow(Exception.class).when(b).voidMethod();
		a.usesVoidMethod();
	}
	
	@Test(expected = RuntimeException.class)
	public void testConsecutiveCalls() throws Exception {
		doNothing().doThrow(Exception.class).when(b).voidMethod();
		a.usesVoidMethod();//call 1 = doNothing -> verify
		verify(b).voidMethod();
		a.usesVoidMethod();//call 2 = doThrow -> expected = RuntimeException
	}

}
