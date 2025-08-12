package dev.jviera.serviplux.serviceorder.application.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CreateQuoteRequest(
    @NotNull(message = "Quote price cannot be null")
    @Positive(message = "Quote price must be positive")
    Double quotePrice
) {}
