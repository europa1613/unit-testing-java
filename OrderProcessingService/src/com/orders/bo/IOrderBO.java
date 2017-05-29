package com.orders.bo;

import com.orders.bo.expection.BOException;
import com.orders.dto.Order;

public interface IOrderBO {

	boolean placeOrder(Order order) throws BOException;

	boolean cancelOrder(int id) throws BOException;

	boolean deleteOrder(int id) throws BOException;

}
