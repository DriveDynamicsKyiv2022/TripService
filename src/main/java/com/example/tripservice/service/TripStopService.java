package com.example.tripservice.service;

import com.example.tripservice.model.trip.stop.TripStopRequestDto;
import com.example.tripservice.model.trip.stop.TripStopResponseDto;
import com.example.tripservice.repository.OrderRepository;
import com.example.tripservice.repository.TrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripStopService {

    private final OrderRepository orderRepository;
    private final TrackingRepository trackingRepository;

    @Autowired
    public TripStopService(OrderRepository orderRepository, TrackingRepository trackingRepository) {
        this.orderRepository = orderRepository;
        this.trackingRepository = trackingRepository;
    }

    public TripStopResponseDto stopTrip(TripStopRequestDto tripStopRequestDto) {
        return new TripStopResponseDto();
    }
}