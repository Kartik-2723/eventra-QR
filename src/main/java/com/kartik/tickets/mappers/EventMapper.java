package com.kartik.tickets.mappers;

import com.kartik.tickets.domain.CreateEventRequest;
import com.kartik.tickets.domain.CreateTicketTypeRequest;
import com.kartik.tickets.domain.dtos.CreateEventRequestDto;
import com.kartik.tickets.domain.dtos.CreateEventResponseDto;
import com.kartik.tickets.domain.dtos.CreateTicketTypeRequestDto;
import com.kartik.tickets.domain.entities.Event;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {

    CreateTicketTypeRequest fromDto(CreateTicketTypeRequestDto dto);

    CreateEventRequest fromDto(CreateEventRequestDto dto);

    CreateEventResponseDto toDto(Event event);

}
