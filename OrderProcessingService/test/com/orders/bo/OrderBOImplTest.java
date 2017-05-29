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
	private OrderBOImpl bo;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		bo = new OrderBOImpl();
		bo.setDao(dao);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void placeOrder_Should_Create_An_Order() throws SQLException, BOException {
		Order order = new Order();
		when(dao.create(order)).thenReturn(1);
		boolean result = bo.placeOrder(order);

		assertTrue(result);
		verify(dao).create(order);
	}

	@Test
	public void placeOrder_Should_not_Create_An_Order() throws SQLException, BOException {
		Order order = new Order();
		when(dao.create(order)).thenReturn(0);
		boolean result = bo.placeOrder(order);

		assertFalse(result);
		verify(dao).create(order);
	}

	@SuppressWarnings("unchecked")
	@Test(expected = BOException.class)
	public void placeOrder_Should_Throw_BOException() throws SQLException, BOException {
		Order order = new Order();
		when(dao.create(order)).thenThrow(SQLException.class);
		bo.placeOrder(order);
	}

	@Test
	public void cancelOrder_Should_Cancel() throws SQLException, BOException {
		Order order = new Order();
		when(dao.read(123)).thenReturn(order);
		when(dao.update(order)).thenReturn(1);

		boolean result = bo.cancelOrder(123);

		assertTrue(result);

		verify(dao).read(123);
		verify(dao).update(order);
	}

	@Test
	public void cancelOrder_Should_not_Cancel() throws SQLException, BOException {
		Order order = new Order();
		when(dao.read(123)).thenReturn(order);
		when(dao.update(order)).thenReturn(0);

		boolean result = bo.cancelOrder(123);

		assertFalse(result);

		verify(dao).read(123);
		verify(dao).update(order);
	}

	@SuppressWarnings("unchecked")
	@Test(expected = BOException.class)
	public void cancelOrder_Should_Throw_BOException_onRead() throws SQLException, BOException {
		when(dao.read(123)).thenThrow(SQLException.class);
		bo.cancelOrder(123);
	}
	
	@SuppressWarnings("unchecked")
	@Test(expected = BOException.class)
	public void cancelOrder_Should_Throw_BOException_onUpdate() throws SQLException, BOException {
		Order order = new Order();
		when(dao.read(123)).thenReturn(order);
		when(dao.update(order)).thenThrow(SQLException.class);

		bo.cancelOrder(123);

		verify(dao).read(123);
		verify(dao).update(order);
	}

}
