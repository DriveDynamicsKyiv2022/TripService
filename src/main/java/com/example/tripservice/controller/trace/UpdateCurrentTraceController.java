package com.example.tripservice.controller.trace;

import com.example.tripservice.model.trip.currentcoordinates.update.UpdateCurrentCoordinatesRequestDto;
import com.example.tripservice.service.trace.UpdateCurrentTraceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UpdateCurrentTraceController {
    private final UpdateCurrentTraceService updateCurrentTraceService;

    @PostMapping("/trip/trace/current/update")
    public ResponseEntity<?> updateCurrentTrace(@RequestBody UpdateCurrentCoordinatesRequestDto requestDto) {
        return updateCurrentTraceService.updateCurrentTrace(requestDto);
    }
}
