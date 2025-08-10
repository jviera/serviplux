package dev.jviera.serviplux.serviceorder.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "service_orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "customer_id", nullable = false)
    private UUID customerId;

    @Column(name = "technician_id")
    private UUID technicianId;

    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;

    @Column(name = "visit_date")
    private LocalDateTime visitDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ServiceStatus status;

    @Column(name = "service_description", length = 500)
    private String serviceDescription;

    @Column(name = "quote_price")
    private Double quotePrice;

    @Column(name = "is_quote_accepted")
    private Boolean isQuoteAccepted;

    @Column(name = "payment_amount")
    private Double paymentAmount;

    @Column(name = "technician_rating")
    private Integer technicianRating;
}
