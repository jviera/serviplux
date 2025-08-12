package dev.jviera.serviplux.serviceorder.application.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record AssignTechnicianRequest(
    @NotNull(message = "Technician ID cannot be null")
    UUID technicianId,

    @NotNull(message = "Visit date cannot be null")
    @Future(message = "Visit date must be in the future")
    LocalDateTime visitDate
) {}
