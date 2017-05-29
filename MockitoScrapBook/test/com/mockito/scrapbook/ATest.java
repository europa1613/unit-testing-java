package com.mockito.scrapbook;

import static org.junit.Assert.assertEquals;
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
		assertEquals(0, a.usesVoidMethod());
		verify(b, times(1)).voidMethod();
	}

}
