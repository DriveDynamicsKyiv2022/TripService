package com.drivedynamics.tripservice.controller;

import com.drivedynamics.tripservice.exception.ValidationException;
import com.drivedynamics.tripservice.model.Order;
import com.drivedynamics.tripservice.model.trip.status.finish.FinishRequestDto;
import com.drivedynamics.tripservice.model.trip.status.start.StartRequestDto;
import com.drivedynamics.tripservice.model.trip.status.start.StartResponseDto;
import com.drivedynamics.tripservice.model.trip.status.stop.StopRequestDto;
import com.drivedynamics.tripservice.model.trip.status.stop.StopResponseDto;
import com.drivedynamics.tripservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Pattern;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/trip")
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/")
    public ResponseEntity<?> getOrder(@Pattern(regexp = "[a-z0-9]{1,24}") @RequestParam String id) throws Exception {
        Order responseBody = orderService.getOrder(id);
        return ResponseEntity.ok(responseBody);
    }

    @PostMapping("/start")
    public ResponseEntity<?> startTrip(@Validated @RequestBody StartRequestDto orderStartRequestdto, BindingResult errors) throws ValidationException {
        StartResponseDto responseBody = orderService.startTrip(orderStartRequestdto, errors);
        return ResponseEntity.ok(responseBody);
    }

    @PatchMapping("/stop")
    public ResponseEntity<?> stopTrip(@Validated @RequestBody StopRequestDto stopRequestdto, BindingResult errors) throws Exception {
        StopResponseDto responseBody = orderService.stopTrip(stopRequestdto, errors);
        return ResponseEntity.ok(responseBody);
    }

    @PatchMapping("/finish")
    public ResponseEntity<?> finishTrip(@Validated @RequestBody FinishRequestDto finishRequestdto, BindingResult errors) throws Exception {
        return orderService.finishTrip(finishRequestdto, errors);
    }
}
