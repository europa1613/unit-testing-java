package com.orders.bo;

import java.sql.SQLException;

import com.orders.bo.expection.BOException;
import com.orders.dao.IOrderDAO;
import com.orders.dto.Order;

public class OrderBOImpl implements IOrderBO {

	private IOrderDAO dao;

	@Override
	public boolean placeOrder(Order order) throws BOException {

		try {
			int result = dao.create(order);

			if (result == 0) {
				return false;
			}

		} catch (SQLException e) {
			throw new BOException(e);
		}

		return true;
	}

	@Override
	public boolean cancelOrder(int id) throws BOException {
		try {
			Order order = dao.read(id);
			order.setStatus("CANCELLED");
			int result = dao.update(order);
			if (result == 0) {
				return false;
			}
		} catch (SQLException e) {
			throw new BOException(e);
		}
		return true;
	}

	@Override
	public boolean deleteOrder(int id) throws BOException {
		try {
			int result = dao.delete(id);
			if (result == 0) {
				return false;
			}
		} catch (SQLException e) {
			throw new BOException(e);
		}

		return true;
	}

	/**
	 * @return the dao
	 */
	/*public IOrderDAO getDao() {
		return dao;
	}*/

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setDao(IOrderDAO dao) {
		this.dao = dao;
	}

}
