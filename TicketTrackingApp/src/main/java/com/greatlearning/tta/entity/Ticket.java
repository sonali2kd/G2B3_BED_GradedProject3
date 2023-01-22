package com.greatlearning.tta.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tickets")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "ticketTitle")
	private String ticketTitle;

	@Column(name = "ticketShortDescription")
	private String ticketShortDescription;

	@Column(name = "ticketCreatedOn")
	private String ticketCreatedOn;

	public String getTicketCreatedOn() {
		return ticketCreatedOn;
	}

	public void setTicketCreatedOn(String ticketCreatedOn) {
		this.ticketCreatedOn = ticketCreatedOn;
	}

	public Ticket() {

	}

	public Ticket(String ticketTitle, String ticketShortDescription, String ticketCreatedOn) {

		this.ticketTitle = ticketTitle;
		this.ticketShortDescription = ticketShortDescription;
		this.ticketCreatedOn = ticketCreatedOn;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTicketTitle() {
		return ticketTitle;
	}

	public void setTicketTitle(String ticketTitle) {
		this.ticketTitle = ticketTitle;
	}

	public String getTicketShortDescription() {
		return ticketShortDescription;
	}

	public void setTicketShortDescription(String ticketShortDescription) {
		this.ticketShortDescription = ticketShortDescription;
	}

}