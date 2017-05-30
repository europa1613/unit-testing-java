package com.europa.spring.junit.dao;

import org.springframework.stereotype.Component;

import com.europa.spring.junit.dto.Ticket;

@Component
public class TickerDAOImpl implements ITicketDAO {

	public int creatTicket(Ticket ticket) {
		return 1;
	}

}
