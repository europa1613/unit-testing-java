package com.mockito.spy;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class ListTest {

	@Spy
	List<String> myList = new ArrayList<String>();

	@Mock
	ArrayList<String> myListMock = new ArrayList<String>();

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_spy_doReturn() {
		myList.add("Jupiter");
		myList.add("Saturn");
		Mockito.doReturn(3).when(myList).size();
		assertEquals(3, myList.size());
	}

	@Test
	public void test_spy_when() {
		// Mockito.when(myList.get(0)).thenReturn("Eclipse"); // cannot use when
		// with spy, IndexOutOfBounds -> calls actual method -- FAILS
		Mockito.doReturn("Eclipse").when(myList).get(0);
		assertEquals("Eclipse", myList.get(0));
	}

	@Test
	public void test_mock() {
		Mockito.when(myListMock.get(0)).thenReturn("Eclipse");
		Mockito.when(myListMock.size()).thenCallRealMethod();
		assertEquals(0, myListMock.size());
		assertEquals("Eclipse", myListMock.get(0));
	}

}
