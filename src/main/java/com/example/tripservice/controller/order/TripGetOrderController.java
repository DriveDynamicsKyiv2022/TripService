package com.example.tripservice.controller.order;

import com.example.tripservice.model.Order;
import com.example.tripservice.service.order.TripGetOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TripGetOrderController {

    @Autowired
    private final TripGetOrderService tripGetOrderService;

    @GetMapping("/trip")
    public ResponseEntity<?> getOrder(@RequestParam String id) {
        Order responseBody = tripGetOrderService.getOrder(id);
        return ResponseEntity.ok(responseBody);
    }
}
