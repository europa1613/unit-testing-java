package com.europa.spring.junit.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.europa.spring.junit.dao.ITicketDAO;
import com.europa.spring.junit.dto.Ticket;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class TicketServiceImplTest {

	private static final int RESULT = 1;
	private static final String NUMBER = "23423434";
	private static final String NAME = "Jupiter";

	@Mock
	ITicketDAO dao;

	@Autowired
	@InjectMocks
	private TicketServiceImpl service;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Mockito.when(dao.creatTicket(any(Ticket.class))).thenReturn(1);
		int result = service.buyTickt(NAME, NUMBER);
		assertEquals(RESULT, result);
	}

}
