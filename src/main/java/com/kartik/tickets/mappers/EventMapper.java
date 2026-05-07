package com.kartik.tickets.mappers;

import com.kartik.tickets.domain.CreateEventRequest;
import com.kartik.tickets.domain.CreateTicketTypeRequest;
import com.kartik.tickets.domain.UpdateEventRequest;
import com.kartik.tickets.domain.UpdateTicketTypeRequest;
import com.kartik.tickets.domain.dtos.*;
import com.kartik.tickets.domain.entities.Event;
import com.kartik.tickets.domain.entities.TicketType;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {

    CreateTicketTypeRequest fromDto(CreateTicketTypeRequestDto dto);

    CreateEventRequest fromDto(CreateEventRequestDto dto);

    CreateEventResponseDto toDto(Event event);

    CreateTicketTypeResponseDto toDto(TicketType ticketType);

    ListEventTicketTypeResponseDto toListEventTicketTypeResponseDto(TicketType ticketType);

    ListEventResponseDto toListEventResponseDto(Event event);

    GetEventDetailsTicketTypesResponseDto toGetEventDetailsTicketTypesResponseDto(TicketType ticketType);

    GetEventDetailsResponseDto toGetEventDetailsResponseDto(Event event);

    UpdateTicketTypeRequest fromDto(UpdateTicketTypeRequestDto dto);

    UpdateEventRequest fromDto(UpdateEventRequestDto dto);

    UpdateTicketTypeResponseDto toUpdateTicketTypeResponseDto(TicketType ticketType);

    UpdateEventResponseDto toUpdateEventResponseDto(Event event);

    ListPublishedEventResponseDto toListPublishedEventResponseDto(Event event);

    GetPublishedEventDetailsTicketTypesResponseDto toGetPublishedEventDetailsTicketTypesResponseDto(TicketType ticketType);

    GetPublishedEventDetailsResponseDto toGetPublishedEventDetailsResponseDto(Event event);

}
