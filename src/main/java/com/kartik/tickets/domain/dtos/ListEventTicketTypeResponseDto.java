package com.kartik.tickets.domain.dtos;

import com.kartik.tickets.domain.entities.Event;
import com.kartik.tickets.domain.entities.Ticket;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListEventTicketTypeResponseDto {
    private UUID id;
    private String name;
    private Double price;
    private String description;
    private Integer totalAvailable;
}
