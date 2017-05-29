package com.mockito.spy;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class ListTest {

	@Spy
	List<String> myList = new ArrayList<String>();
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		myList.add("Jupiter");
		myList.add("Saturn");
		//Mockito.when(myList.get(0)).thenReturn("Eclipse"); // comment above add's, cannot use with spy, IndexOutOfBounds
		Mockito.doReturn(3).when(myList).size();
		assertEquals(3, myList.size());
	}

}
