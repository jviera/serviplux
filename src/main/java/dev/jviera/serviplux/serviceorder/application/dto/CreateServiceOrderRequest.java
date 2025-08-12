package dev.jviera.serviplux.serviceorder.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CreateServiceOrderRequest(
    @NotNull(message = "Customer ID cannot be null")
    UUID customerId,

    @NotBlank(message = "Service description cannot be blank")
    String serviceDescription
) {}
