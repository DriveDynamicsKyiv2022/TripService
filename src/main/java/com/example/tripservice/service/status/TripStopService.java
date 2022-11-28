package com.example.tripservice.service.status;

import com.example.tripservice.model.trip.status.stop.TripStopRequestDto;
import com.example.tripservice.model.trip.status.stop.TripStopResponseDto;
import com.example.tripservice.repository.OrderRepository;
import com.example.tripservice.repository.TracingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripStopService {

    private final OrderRepository orderRepository;
    private final TracingRepository tracingRepository;

    @Autowired
    public TripStopService(OrderRepository orderRepository, TracingRepository tracingRepository) {
        this.orderRepository = orderRepository;
        this.tracingRepository = tracingRepository;
    }

    public TripStopResponseDto stopTrip(TripStopRequestDto tripStopRequestDto) {
        return new TripStopResponseDto();
    }
}