package com.drivedynamic.tripservice.service.trace;

import com.drivedynamic.tripservice.model.trip.currentcoordinates.update.UpdateCurrentCoordinatesRequestDto;
import com.drivedynamic.tripservice.repository.ITracingRepository;
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
