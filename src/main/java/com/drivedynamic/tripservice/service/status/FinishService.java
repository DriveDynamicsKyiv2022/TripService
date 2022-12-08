package com.drivedynamic.tripservice.service.status;

import com.drivedynamic.tripservice.model.trip.status.finish.FinishRequestDto;
import com.drivedynamic.tripservice.repository.IOrderRepository;
import com.drivedynamic.tripservice.repository.ITracingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FinishService {

    private final IOrderRepository orderRepository;
    private final ITracingRepository tracingRepository;

    public ResponseEntity finishTrip(FinishRequestDto finishRequestDto) {
        return ResponseEntity.ok().build();
    }
}