package com.greatlearning.tta.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

		return "view_tickets";
	}

	@GetMapping("/tickets/new")
	public String addTicketButtonClicked(Model model) {

		Ticket ticket = new Ticket();
		model.addAttribute("ticket", ticket);

		return "create_ticket";
	}

	@PostMapping("/tickets")
	public String submitButtonClickedForAddTicket(@ModelAttribute("ticket") Ticket ticket) {

		ticket = ticketService.saveTicket(ticket);
		return "redirect:/tickets/";
	}
	// Add Ticket - END

	// Update Ticket - Start
	@GetMapping("/tickets/edit/{id}")
	public String updateTicketButtonClicked(@PathVariable Long id, Model model) {

		Ticket selectedTicket= ticketService.getTicketById(id);

		model.addAttribute("ticket", selectedTicket);

		return "edit_ticket";
		
	}

	@PostMapping("/tickets/{id}")
	public String submitButtonClickedForUpdateTicket(@PathVariable Long id, @ModelAttribute("ticket") Ticket ticket) {

		// Update the ticket object
		Ticket existingTicketObj = ticketService.getTicketById(id);

		existingTicketObj.setTicketTitle(ticket.getTicketTitle());
		existingTicketObj.setTicketShortDescription(ticket.getTicketShortDescription());
		existingTicketObj.setTicketCreatedOn(ticket.getTicketCreatedOn());

		ticketService.updateTicket(ticket);

		return "redirect:/tickets";
	}

	// Update Tickets - End

	@GetMapping("/tickets/{id}")
	public String deleteTicket(@PathVariable Long id) {

		ticketService.deleteById(id);
		return "redirect:/tickets";
	}

	@GetMapping("/tickets/search")
	public String search(
			@RequestParam("ticketTitle") String ticketTitle,
			@RequestParam("ticketShortDescription") String ticketShortDescription,
			Model model) {
		
		if(ticketTitle.trim().isEmpty() && ticketShortDescription.trim().isEmpty()) {
			return "redirect:/tickets";
		}else {
			List<Ticket> tickets = ticketService.searchBy(ticketTitle, ticketShortDescription);
			
			model.addAttribute("Tickets", tickets);
			
			return "view_tickets";
		}
		
		
	}
}