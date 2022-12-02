package com.example.tripservice.controller.trace;

import com.example.tripservice.service.trace.TripGetTraceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TripGetTraceController {
    private final TripGetTraceService tripGetTraceService;

    @GetMapping("/trip/trace")
    public ResponseEntity<?> getTrace(@RequestParam String id) {
        var responseBody = tripGetTraceService.getTrace(id);
        return ResponseEntity.ok(responseBody);
    }
}
