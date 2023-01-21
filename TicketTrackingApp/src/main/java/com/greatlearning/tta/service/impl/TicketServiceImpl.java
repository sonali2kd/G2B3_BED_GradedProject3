package com.greatlearning.tta.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greatlearning.tta.entity.Ticket;
import com.greatlearning.tta.repository.TicketRepository;
import com.greatlearning.tta.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService{

	private TicketRepository ticketRepository;
	
	public TicketServiceImpl(TicketRepository ticketRepository) {
		
		this.ticketRepository = ticketRepository;
	}
	
	@Override
	public List<Ticket> listTickets() {
		return ticketRepository.findAll();
	}

	@Override
	public Ticket saveTicket(Ticket ticket) {
		
		return ticketRepository.save(ticket);
	}

	@Override
	public Ticket updateTicket(Ticket ticket) {
		
		return ticketRepository.save(ticket);
	}

	@Override
	public Ticket getTicketById(Long id) {
		
		return ticketRepository.findById(id).get();		
	}

	@Override
	public void deleteById(Long id) {
		
		ticketRepository.deleteById(id);
	}
	
	public List<Ticket> getByKeyword(String keyword){
		  return ticketRepository.findByKeyword(keyword);
		 }
	
}
