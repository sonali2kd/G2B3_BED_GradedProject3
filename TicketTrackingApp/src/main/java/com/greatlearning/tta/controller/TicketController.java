package com.greatlearning.tta.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.greatlearning.tta.entity.Ticket;
import com.greatlearning.tta.service.TicketService;

@Controller
public class TicketController {

	private TicketService ticketService;
	
	public TicketController(TicketService ticketService) {
		
		this.ticketService = ticketService;
	}
	
	@GetMapping("/tickets")
	public String listTickets(Model model) {
		
		List<Ticket> tickets = ticketService.listTickets();
			
		model.addAttribute("tickets", tickets);
		
		return "tickets";
	}
	
	@GetMapping("/tickets/new")
	public String addTicketButtonClicked(Model model) {
		
		Ticket ticket = new Ticket();
		model.addAttribute("ticket", ticket);
		
		return "create_ticket";
	}
	
	@PostMapping("/tickets")
	public String submitButtonClickedForAddTicket(
		@ModelAttribute("ticket")Ticket ticket) {
		
		ticketService.saveTicket(ticket);
		return "redirect:/tickets";
	}	
	// Add Ticket - END
	
	//  Update Ticket - Start	
	@GetMapping("/tickets/edit/{id}")
	public String updateTicketButtonClicked(		
		@PathVariable Long id,
		Model model) {
				
		Ticket selectedTicket = new Ticket();
		
		model.addAttribute("ticket", selectedTicket);
		
		return "edit_ticket";
	}
	
	@PostMapping("/tickets/{id}")
	public String submitButtonClickedForUpdateTicket(
		@PathVariable Long id,
		@ModelAttribute("ticket")Ticket ticket) {
		
		//  Update the ticket object		
		Ticket existingTicketObj 
			= ticketService.getTicketById(id);
		
		existingTicketObj.setticketTitle(ticket.getticketTitle());
		existingTicketObj.setticketShortDescription(ticket.getticketShortDescription());
		existingTicketObj.setTicketCreatedOn(ticket.getTicketCreatedOn());
		
		ticketService.updateTicket(ticket);
		
		return "redirect:/tickets";
	}	
	
	// Update Tickets - End
	
	@GetMapping ("/tickets/{id}")
	public String deleteTicket(
		@PathVariable Long id	) {
		
		ticketService.deleteById(id);
		return "redirect:/tickets";
	}
	
	@GetMapping({"/", "/search"})
	 public String home(Ticket ticket, Model model, String keyword) {
	  if(keyword!=null) {
	   List<Ticket> list = ticketService.getByKeyword(keyword);
	   model.addAttribute("list", list);
	  }else {
	  List<Ticket> list = ticketService.listTickets();
	  model.addAttribute("list", list);}
	  return "index";
	 }
}