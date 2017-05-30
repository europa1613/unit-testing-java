package com.europa.spring.junit.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.europa.spring.junit.dao.ITicketDAO;

public class TicketServiceImplTest {

	private static final int RESULT = 1;
	private static final String NUMBER = "23423434";
	private static final String NAME = "Jupiter";
	
	@Mock
	ITicketDAO dao;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		TicketServiceImpl service = new TicketServiceImpl();
		int result = service.buyTickt(NAME, NUMBER);
		assertEquals(RESULT, result);
	}

}
