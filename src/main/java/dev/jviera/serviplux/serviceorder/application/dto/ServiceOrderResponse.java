package dev.jviera.serviplux.serviceorder.application.dto;

import dev.jviera.serviplux.serviceorder.domain.ServiceStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record ServiceOrderResponse(
    UUID id,
    UUID customerId,
    UUID technicianId,
    LocalDateTime creationDate,
    LocalDateTime visitDate,
    ServiceStatus status,
    String serviceDescription,
    Double quotePrice,
    Boolean isQuoteAccepted
) {}
