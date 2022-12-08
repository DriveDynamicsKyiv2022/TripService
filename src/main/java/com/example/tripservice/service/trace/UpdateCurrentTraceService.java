package com.example.tripservice.service.trace;

import com.example.tripservice.model.trip.currentcoordinates.update.UpdateCurrentCoordinatesRequestDto;
import com.example.tripservice.repository.ITracingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateCurrentTraceService {
    private final ITracingRepository tracingRepository;

    public ResponseEntity updateCurrentTrace(UpdateCurrentCoordinatesRequestDto requestDto) {
        return ResponseEntity.ok().build();
    }
}
