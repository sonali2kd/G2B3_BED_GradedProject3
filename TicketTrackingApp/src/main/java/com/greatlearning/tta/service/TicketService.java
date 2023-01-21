package com.greatlearning.tta.service;

import java.util.List;

import com.greatlearning.tta.entity.Ticket;

public interface TicketService {

	List<Ticket> listTickets();
	
	Ticket saveTicket(Ticket ticket);
	
	// Update - Start	
	Ticket updateTicket(Ticket ticket);
	
	Ticket getTicketById(Long id);	
	//  Update - End
	
	void deleteById(Long id);

	List<Ticket> getByKeyword(String keyword);
	
}