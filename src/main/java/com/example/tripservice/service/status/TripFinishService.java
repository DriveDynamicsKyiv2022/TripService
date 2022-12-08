package com.example.tripservice.service.status;

import com.example.tripservice.model.trip.status.finish.TripFinishRequestDto;
import com.example.tripservice.repository.IOrderRepository;
import com.example.tripservice.repository.ITracingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TripFinishService {

    private final IOrderRepository orderRepository;
    private final ITracingRepository tracingRepository;

    @Autowired
    public TripFinishService(IOrderRepository orderRepository, ITracingRepository tracingRepository) {
        this.orderRepository = orderRepository;
        this.tracingRepository = tracingRepository;
    }

    public ResponseEntity finishTrip(TripFinishRequestDto tripFinishRequestDto) {
        return ResponseEntity.ok().build();
    }
}