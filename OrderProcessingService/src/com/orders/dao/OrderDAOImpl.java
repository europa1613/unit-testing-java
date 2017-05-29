/**
 * 
 */
package com.orders.dao;

import java.sql.SQLException;

import com.orders.dto.Order;

/**
 * @author arvins-macpro
 *
 */
public class OrderDAOImpl implements IOrderDAO {

	/* (non-Javadoc)
	 * @see com.orders.dao.IOrderDAO#create(com.orders.dto.Order)
	 */
	@Override
	public int create(Order order) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.orders.dao.IOrderDAO#read(int)
	 */
	@Override
	public Order read(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.orders.dao.IOrderDAO#update(com.orders.dto.Order)
	 */
	@Override
	public int update(Order order) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.orders.dao.IOrderDAO#delete(int)
	 */
	@Override
	public int delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
