package dev.jviera.serviplux.serviceorder.application;

import dev.jviera.serviplux.serviceorder.application.dto.AssignTechnicianRequest;
import dev.jviera.serviplux.serviceorder.application.dto.CreateQuoteRequest;
import dev.jviera.serviplux.serviceorder.application.dto.CreateServiceOrderRequest;
import dev.jviera.serviplux.serviceorder.domain.ServiceOrder;
import dev.jviera.serviplux.serviceorder.domain.ServiceStatus;
import dev.jviera.serviplux.serviceorder.exception.ServiceOrderNotFoundException;
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

    @Transactional
    public ServiceOrder createServiceOrder(CreateServiceOrderRequest request) {
        ServiceOrder order = new ServiceOrder();
        order.setCustomerId(request.customerId());
        order.setServiceDescription(request.serviceDescription());
        order.setCreationDate(LocalDateTime.now());
        order.setStatus(ServiceStatus.PENDING_ASSIGNMENT);
        return serviceOrderRepository.save(order);
    }

    @Transactional
    public ServiceOrder assignTechnicianAndScheduleVisit(UUID orderId, AssignTechnicianRequest request) {
        return serviceOrderRepository.findById(orderId).map(order -> {
            order.setTechnicianId(request.technicianId());
            order.setVisitDate(request.visitDate());
            order.setStatus(ServiceStatus.SCHEDULED);
            return serviceOrderRepository.save(order);
        }).orElseThrow(() -> new ServiceOrderNotFoundException("Service order not found with id: " + orderId));
    }

    @Transactional
    public ServiceOrder createQuote(UUID orderId, CreateQuoteRequest request) {
        return serviceOrderRepository.findById(orderId).map(order -> {
            order.setQuotePrice(request.quotePrice());
            order.setStatus(ServiceStatus.PENDING_QUOTE_ACCEPTANCE);
            return serviceOrderRepository.save(order);
        }).orElseThrow(() -> new ServiceOrderNotFoundException("Service order not found with id: " + orderId));
    }
}