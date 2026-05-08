package com.kartik.tickets.services.impl;

import com.kartik.tickets.domain.entities.Ticket;
import com.kartik.tickets.domain.entities.TicketStatusEnum;
import com.kartik.tickets.domain.entities.TicketType;
import com.kartik.tickets.domain.entities.User;
import com.kartik.tickets.exceptions.TicketTypeNotFoundException;
import com.kartik.tickets.exceptions.TicketsSoldOutException;
import com.kartik.tickets.exceptions.UserNotFoundException;
import com.kartik.tickets.repositories.TicketRepository;
import com.kartik.tickets.repositories.TicketTypeRepository;
import com.kartik.tickets.repositories.UserRepository;
import com.kartik.tickets.services.QrCodeService;
import com.kartik.tickets.services.TicketTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TicketTypeServiceImpl implements TicketTypeService {

    private final UserRepository userRepository;
    private final TicketRepository ticketRepository;
    private final TicketTypeRepository ticketTypeRepository;
    private final QrCodeService qrCodeService;

    @Override
    @Transactional
    public Ticket purchaseTicket(UUID userId, UUID ticketTypeId) {

        User user = userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException(
                String.format("User with ID %s was not found",userId)
        ));

        TicketType ticketType = ticketTypeRepository.findByIdWithLock(ticketTypeId).orElseThrow(()-> new TicketTypeNotFoundException(
                String.format("Ticket type with ID %s was not found",ticketTypeId)
        ));

        int purchasedTickets = ticketRepository.countTicketTypeById(ticketType.getId());
        Integer totalAvailable = ticketType.getTotalAvailable();

        if(purchasedTickets+1>totalAvailable){
            throw new TicketsSoldOutException();
        }

        Ticket ticket = new Ticket();
        ticket.setStatus(TicketStatusEnum.PURCHASED);
        ticket.setTicketType(ticketType);
        ticket.setPurchaser(user);

        Ticket savedTicket = ticketRepository.save(ticket);
        qrCodeService.generateQrCode(savedTicket);

        return ticketRepository.save(savedTicket);

    }
}
