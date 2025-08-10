package dev.jviera.serviplux.serviceorder.application;

import dev.jviera.serviplux.serviceorder.domain.ServiceOrder;
import dev.jviera.serviplux.serviceorder.domain.ServiceStatus;
import dev.jviera.serviplux.serviceorder.persistence.ServiceOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ServiceOrderService {

    private final ServiceOrderRepository serviceOrderRepository;

    // Método para crear una nueva orden de servicio
    @Transactional
    public ServiceOrder createServiceOrder(UUID customerId, String description) {
        ServiceOrder order = new ServiceOrder();
        order.setCustomerId(customerId);
        order.setServiceDescription(description);
        order.setCreationDate(LocalDateTime.now());
        order.setStatus(ServiceStatus.PENDING_ASSIGNMENT);
        return serviceOrderRepository.save(order);
    }

    // Método para asignar un técnico y una fecha de visita
    @Transactional
    public ServiceOrder assignTechnicianAndScheduleVisit(UUID orderId, UUID technicianId, LocalDateTime visitDate) {
        return serviceOrderRepository.findById(orderId).map(order -> {
            order.setTechnicianId(technicianId);
            order.setVisitDate(visitDate);
            order.setStatus(ServiceStatus.SCHEDULED);
            return serviceOrderRepository.save(order);
        }).orElseThrow(() -> new IllegalArgumentException("Order not found"));
    }

    // Método para realizar una cotización
    @Transactional
    public ServiceOrder createQuote(UUID orderId, Double quotePrice) {
        return serviceOrderRepository.findById(orderId).map(order -> {
            order.setQuotePrice(quotePrice);
            order.setStatus(ServiceStatus.PENDING_QUOTE_ACCEPTANCE);
            return serviceOrderRepository.save(order);
        }).orElseThrow(() -> new IllegalArgumentException("Order not found"));
    }
}