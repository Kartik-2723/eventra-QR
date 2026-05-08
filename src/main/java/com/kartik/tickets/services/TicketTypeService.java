package com.kartik.tickets.services;

import com.kartik.tickets.domain.entities.Ticket;

import java.util.UUID;

public interface TicketTypeService {
    Ticket purchaseTicket(UUID userId,UUID ticketTypeId);
}
