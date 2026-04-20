package com.kartik.tickets.services;

import com.kartik.tickets.domain.CreateEventRequest;
import com.kartik.tickets.domain.entities.Event;

import java.util.UUID;

public interface EventService {
    Event createEvent(UUID organizerId,CreateEventRequest event);
}
