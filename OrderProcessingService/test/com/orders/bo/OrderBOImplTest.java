package com.orders.bo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.orders.bo.expection.BOException;
import com.orders.dao.IOrderDAO;
import com.orders.dto.Order;

public class OrderBOImplTest {
	@Mock
	IOrderDAO dao;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void placeOrder_Should_Create_An_Order() throws SQLException, BOException {
		OrderBOImpl bo = new OrderBOImpl();
		bo.setDao(dao);

		Order order = new Order();
		when(dao.create(order)).thenReturn(1);
		boolean result = bo.placeOrder(order);
		
		assertTrue(result);
		verify(dao).create(order);
	}

}
