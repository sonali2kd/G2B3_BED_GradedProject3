package com.greatlearning.tta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.greatlearning.tta.entity.Ticket;

public interface TicketRepository
	extends JpaRepository<Ticket, Long>{
	@Query(value = "select * from ticket t where t.ticketTitle like %:keyword% or t.ticketShortDescription like %:keyword%", nativeQuery = true)
	 List<Ticket> findByKeyword(@Param("keyword") String keyword);

}