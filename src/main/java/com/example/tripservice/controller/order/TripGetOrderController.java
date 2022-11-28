package com.example.tripservice.controller.order;

import com.example.tripservice.service.order.TripGetOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TripGetOrderController {

    private final TripGetOrderService tripGetOrderService;

    @GetMapping("/trip/{id}")
    public ResponseEntity<?> getOrder(@RequestParam String id) {
        var responseBody = tripGetOrderService.getOrder(id);
        return ResponseEntity.ok(responseBody);
    }
}