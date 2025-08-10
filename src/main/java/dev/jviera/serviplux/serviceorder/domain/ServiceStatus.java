package dev.jviera.serviplux.serviceorder.domain;

public enum ServiceStatus {
    PENDING_ASSIGNMENT,
    SCHEDULED,
    IN_PROGRESS,
    PENDING_QUOTE_ACCEPTANCE,
    COMPLETED,
    CANCELLED
}
