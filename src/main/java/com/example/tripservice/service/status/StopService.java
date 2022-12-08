package com.example.tripservice.service.status;

import com.example.tripservice.model.trip.status.stop.StopRequestDto;
import com.example.tripservice.model.trip.status.stop.StopResponseDto;
import com.example.tripservice.repository.IOrderRepository;
import com.example.tripservice.repository.ITracingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StopService {

    private final IOrderRepository orderRepository;
    private final ITracingRepository tracingRepository;

    public StopResponseDto stopTrip(StopRequestDto stopRequestDto) {
        return new StopResponseDto();
    }
}