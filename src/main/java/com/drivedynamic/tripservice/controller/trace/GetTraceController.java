package com.drivedynamic.tripservice.controller.trace;

import com.drivedynamic.tripservice.model.Tracing;
import com.drivedynamic.tripservice.service.trace.GetTraceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetTraceController {
    private final GetTraceService getTraceService;

    @GetMapping("/trip/trace")
    public ResponseEntity<?> getTrace(@RequestParam String id) {
        Tracing responseBody = getTraceService.getTrace(id);
        return ResponseEntity.ok(responseBody);
    }
}
