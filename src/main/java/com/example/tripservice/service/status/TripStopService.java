package com.example.tripservice.service.status;

import com.example.tripservice.model.trip.status.stop.TripStopRequestDto;
import com.example.tripservice.model.trip.status.stop.TripStopResponseDto;
import com.example.tripservice.repository.IOrderRepository;
import com.example.tripservice.repository.ITracingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripStopService {

    private final IOrderRepository orderRepository;
    private final ITracingRepository tracingRepository;

    @Autowired
    public TripStopService(IOrderRepository orderRepository, ITracingRepository tracingRepository) {
        this.orderRepository = orderRepository;
        this.tracingRepository = tracingRepository;
    }

    public TripStopResponseDto stopTrip(TripStopRequestDto tripStopRequestDto) {
        return new TripStopResponseDto();
    }
}