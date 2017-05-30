package com.europa.spring.junit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.europa.spring.junit.dao.ITicketDAO;
import com.europa.spring.junit.dto.Ticket;

@Component
public class TicketServiceImpl implements ITicketService {

	@Autowired
	private ITicketDAO dao;

	public int buyTickt(String name, String phone) {
		Ticket ticket = new Ticket();
		ticket.setPassengerName(name);
		ticket.setPhone(phone);
		return dao.creatTicket(ticket);
	}

	/**
	 * @return the dao
	 */
	public ITicketDAO getDao() {
		return dao;
	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setDao(ITicketDAO dao) {
		this.dao = dao;
	}

}
