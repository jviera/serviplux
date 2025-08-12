package dev.jviera.serviplux.serviceorder.application;

import dev.jviera.serviplux.serviceorder.application.dto.ServiceOrderResponse;
import dev.jviera.serviplux.serviceorder.domain.ServiceOrder;
import org.springframework.stereotype.Component;

@Component
public class ServiceOrderMapper {

    public ServiceOrderResponse toResponse(ServiceOrder order) {
        return new ServiceOrderResponse(
                order.getId(),
                order.getCustomerId(),
                order.getTechnicianId(),
                order.getCreationDate(),
                order.getVisitDate(),
                order.getStatus(),
                order.getServiceDescription(),
                order.getQuotePrice(),
                order.getIsQuoteAccepted()
        );
    }
}
