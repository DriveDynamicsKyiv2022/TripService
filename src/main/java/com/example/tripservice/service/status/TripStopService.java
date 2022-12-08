package com.example.tripservice.service.status;

import com.example.tripservice.model.trip.status.stop.TripStopRequestDto;
import com.example.tripservice.model.trip.status.stop.TripStopResponseDto;
import com.example.tripservice.repository.IOrderRepository;
import com.example.tripservice.repository.ITracingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TripStopService {

    private final IOrderRepository orderRepository;
    private final ITracingRepository tracingRepository;

    public TripStopResponseDto stopTrip(TripStopRequestDto tripStopRequestDto) {
        return new TripStopResponseDto();
    }
}