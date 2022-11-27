package com.example.tripservice.service;

import com.example.tripservice.model.trip.finish.TripFinishRequestDto;
import com.example.tripservice.repository.OrderRepository;
import com.example.tripservice.repository.TrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripFinishService {

    private final OrderRepository orderRepository;
    private final TrackingRepository trackingRepository;

    @Autowired
    public TripFinishService(OrderRepository orderRepository, TrackingRepository trackingRepository) {
        this.orderRepository = orderRepository;
        this.trackingRepository = trackingRepository;
    }

    public TripFinishRequestDto finishTrip(TripFinishRequestDto tripFinishRequestDto) {
        return new TripFinishRequestDto("1");
    }
}