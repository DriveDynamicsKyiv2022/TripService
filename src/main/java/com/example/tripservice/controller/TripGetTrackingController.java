package com.example.tripservice.controller;

import com.example.tripservice.service.TripGetTrackingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TripGetTrackingController {
    private final TripGetTrackingService tripGetTrackingService;

    @GetMapping("/trip/{id}")
    public ResponseEntity<?> getTracking(@RequestParam String id) {
        var responseBody = tripGetTrackingService.getTracking(id);
        return ResponseEntity.ok(responseBody);
    }
}
