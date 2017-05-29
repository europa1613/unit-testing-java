package com.orders.bo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
		// Order order = new Order();
		when(dao.create(any(Order.class))).thenReturn(1);
		boolean result = bo.placeOrder(any(Order.class)); // any(Order.class)

		assertTrue(result);
		/**
		 * atLeast() and times() give an Implementation to VerificationMode
		 */
		verify(dao, atLeast(1)).create(any(Order.class)); // or times(1)
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
		when(dao.read(anyInt())).thenThrow(SQLException.class);
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

	@Test
	public void deleteOrder_should_delete() throws SQLException, BOException {
		when(dao.delete(123)).thenReturn(1);
		boolean result = bo.deleteOrder(123);

		assertTrue(result);
		verify(dao).delete(123);
	}

	@Test
	public void deleteOrder_should_not_delete() throws SQLException, BOException {
		when(dao.delete(123)).thenReturn(0);
		boolean result = bo.deleteOrder(123);

		assertFalse(result);
		verify(dao).delete(123);
	}

	@SuppressWarnings("unchecked")
	@Test(expected = BOException.class)
	public void deleteOrder_should_throw_BOException() throws SQLException, BOException {
		when(dao.delete(123)).thenThrow(SQLException.class);
		bo.deleteOrder(123);
	}

}
