package com.drivedynamics.tripservice.controller;

import com.drivedynamics.tripservice.annotation.IdStringConstraint;
import com.drivedynamics.tripservice.exception.ValidationException;
import com.drivedynamics.tripservice.model.document.Order;
import com.drivedynamics.tripservice.model.dto.OrderRequestDto;
import com.drivedynamics.tripservice.model.dto.OrderResponseDto;
import com.drivedynamics.tripservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<?> createOrder(@Validated @RequestBody OrderRequestDto orderRequestdto, BindingResult errors)
            throws ValidationException {
        OrderResponseDto responseBody = orderService.createOrder(orderRequestdto, errors);
        return ResponseEntity.ok(responseBody);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getOrder(@PathVariable @IdStringConstraint String id) {
        Optional<Order> responseBody = orderService.getOrder(id);
        return ResponseEntity.ok(responseBody);
    }

    @PatchMapping("{id}")
    public ResponseEntity<?> updateOrder(@PathVariable @IdStringConstraint String id) {
        Order responseBody = orderService.updateOrder(id);
        return ResponseEntity.ok(responseBody);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> finishOrder(@PathVariable @IdStringConstraint String id) {
        //TODO
        //validate existence
        return orderService.finishOrder(id);
    }
}
