package com.example.tripservice.service;

import com.example.tripservice.model.Order;
import com.example.tripservice.model.Tracking;
import com.example.tripservice.model.constant.Payment;
import com.example.tripservice.model.constant.Status;
import com.example.tripservice.model.tripstart.TripStartRequestDto;
import com.example.tripservice.model.tripstart.TripStartResponseDto;
import com.example.tripservice.repository.OrderRepository;
import com.example.tripservice.repository.TrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TripStartService {

    private final OrderRepository orderRepository;
    private final TrackingRepository trackingRepository;

    @Autowired
    public TripStartService(OrderRepository orderRepository, TrackingRepository trackingRepository) {
        this.orderRepository = orderRepository;
        this.trackingRepository = trackingRepository;
    }

    public TripStartResponseDto startTrip(TripStartRequestDto tripStartRequestDto) {
//        carId >= 1
//        userId >= 1
//        Balance >= 10
//        Latitude range (-90 to 90)
//        Longitude range (-180 to 180)

        Order order = createOrder(tripStartRequestDto);
        Tracking tracking = startTracking(tripStartRequestDto, order.getId());
        return new TripStartResponseDto(
                //TODO mock car service, get car owner's userId
                "1",
                tripStartRequestDto.getUserId(),
                tripStartRequestDto.getCarId(),
                order.getActivationTime(),
                order.getStatus(),
                order.getPayment(),
                order.getBalance(),
                tracking.getId(),
                tracking.getLatitude(),
                tracking.getLongitude(),
                tracking.getSpeed(),
                tracking.getTimestamp(),
                tracking.getDistance()
        );
    }

    private Order createOrder(TripStartRequestDto tripStartRequestDto) {
        Order order = new Order(
                tripStartRequestDto.getUserId(),
                tripStartRequestDto.getCarId(),
                LocalDateTime.now(),
                null,
                tripStartRequestDto.getBalance(),
                Status.IN_ORDER,
                Payment.IN_PROCESS
        );
        orderRepository.insert(order);
        return order;
    }

    private Tracking startTracking(TripStartRequestDto tripStartRequestDto, String orderId) {
        Tracking tracking = new Tracking(
                orderId,
                tripStartRequestDto.getLatitude(), tripStartRequestDto.getLongitude(),
                0d,
                0d,
                LocalDateTime.now()
        );
        trackingRepository.insert(tracking);
        return tracking;
    }
}
