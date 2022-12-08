package com.drivedynamic.tripservice.controller.order;

import com.drivedynamic.tripservice.model.Order;
import com.drivedynamic.tripservice.service.order.GetOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetOrderController {
    private final GetOrderService getOrderService;

    @GetMapping("/trip")
    public ResponseEntity<?> getOrder(@RequestParam String id) {
        Order responseBody = getOrderService.getOrder(id);
        return ResponseEntity.ok(responseBody);
    }
}
