package dev.jviera.serviplux.serviceorder.application;

import dev.jviera.serviplux.serviceorder.application.dto.AssignTechnicianRequest;
import dev.jviera.serviplux.serviceorder.application.dto.CreateQuoteRequest;
import dev.jviera.serviplux.serviceorder.application.dto.CreateServiceOrderRequest;
import dev.jviera.serviplux.serviceorder.application.dto.ServiceOrderResponse;
import dev.jviera.serviplux.serviceorder.domain.ServiceOrder;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/service-orders")
@RequiredArgsConstructor
public class ServiceOrderController {

    private final ServiceOrderService serviceOrderService;
    private final ServiceOrderMapper serviceOrderMapper;

    @PostMapping
    public ResponseEntity<ServiceOrderResponse> createServiceOrder(@Valid @RequestBody CreateServiceOrderRequest request) {
        ServiceOrder createdOrder = serviceOrderService.createServiceOrder(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceOrderMapper.toResponse(createdOrder));
    }

    @PutMapping("/{orderId}/assign")
    public ResponseEntity<ServiceOrderResponse> assignTechnician(
            @PathVariable UUID orderId,
            @Valid @RequestBody AssignTechnicianRequest request) {
        ServiceOrder updatedOrder = serviceOrderService.assignTechnicianAndScheduleVisit(orderId, request);
        return ResponseEntity.ok(serviceOrderMapper.toResponse(updatedOrder));
    }

    @PostMapping("/{orderId}/quote")
    public ResponseEntity<ServiceOrderResponse> createQuote(
            @PathVariable UUID orderId,
            @Valid @RequestBody CreateQuoteRequest request) {
        ServiceOrder updatedOrder = serviceOrderService.createQuote(orderId, request);
        return ResponseEntity.ok(serviceOrderMapper.toResponse(updatedOrder));
    }
}
