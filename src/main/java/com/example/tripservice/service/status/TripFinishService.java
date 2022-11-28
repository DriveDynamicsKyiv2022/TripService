package com.example.tripservice.service.status;

import com.example.tripservice.model.trip.status.finish.TripFinishRequestDto;
import com.example.tripservice.repository.OrderRepository;
import com.example.tripservice.repository.TracingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripFinishService {

    private final OrderRepository orderRepository;
    private final TracingRepository tracingRepository;

    @Autowired
    public TripFinishService(OrderRepository orderRepository, TracingRepository tracingRepository) {
        this.orderRepository = orderRepository;
        this.tracingRepository = tracingRepository;
    }

    public TripFinishRequestDto finishTrip(TripFinishRequestDto tripFinishRequestDto) {
        return new TripFinishRequestDto("1");
    }
}