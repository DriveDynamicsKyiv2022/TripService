package com.drivedynamics.tripservice.controller;

import com.drivedynamics.tripservice.model.Order;
import com.drivedynamics.tripservice.model.trip.status.finish.FinishRequestDto;
import com.drivedynamics.tripservice.model.trip.status.start.StartRequestDto;
import com.drivedynamics.tripservice.model.trip.status.start.StartResponseDto;
import com.drivedynamics.tripservice.model.trip.status.stop.StopRequestDto;
import com.drivedynamics.tripservice.model.trip.status.stop.StopResponseDto;
import com.drivedynamics.tripservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/trip")
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/")
    public ResponseEntity<?> getOrder(@RequestParam String id) throws Exception {
        Order responseBody = orderService.getOrder(id);
        return ResponseEntity.ok(responseBody);
    }

    @PostMapping("/start")
    public ResponseEntity<?> startTrip(@Valid @RequestBody StartRequestDto orderStartRequestdto) {
        StartResponseDto responseBody = orderService.startTrip(orderStartRequestdto);
        return ResponseEntity.ok(responseBody);
    }

    @PatchMapping("/stop")
    public ResponseEntity<?> stopTrip(@RequestBody StopRequestDto stopRequestdto) throws Exception {
        StopResponseDto responseBody = orderService.stopTrip(stopRequestdto);
        return ResponseEntity.ok(responseBody);
    }

    @PatchMapping("/finish")
    public ResponseEntity<?> finishTrip(@RequestBody FinishRequestDto finishRequestdto) throws Exception {
        return orderService.finishTrip(finishRequestdto);
    }
}
