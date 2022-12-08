package com.example.tripservice.service.status;

import com.example.tripservice.model.Order;
import com.example.tripservice.model.Tracing;
import com.example.tripservice.model.constant.Payment;
import com.example.tripservice.model.constant.Status;
import com.example.tripservice.model.trip.status.start.TripStartRequestDto;
import com.example.tripservice.model.trip.status.start.TripStartResponseDto;
import com.example.tripservice.repository.IOrderRepository;
import com.example.tripservice.repository.ITracingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TripStartService {

    private final IOrderRepository orderRepository;
    private final ITracingRepository tracingRepository;

    public TripStartResponseDto startTrip(TripStartRequestDto tripStartRequestDto) {
//        carId >= 1
//        userId >= 1
//        Balance >= 10
//        Latitude range (-90 to 90)
//        Longitude range (-180 to 180)

        Order order = createOrder(tripStartRequestDto);
        Tracing tracing = startTracing(tripStartRequestDto, order.getId());
        return new TripStartResponseDto(
                //TODO mock car service, get car owner's userId
                "1",
                tripStartRequestDto.getUserId(),
                tripStartRequestDto.getCarId(),
                order.getActivationTime(),
                order.getStatus(),
                order.getPayment(),
                order.getBalance(),
                tracing.getId(),
                tracing.getLatitude(),
                tracing.getLongitude(),
                tracing.getSpeed(),
                tracing.getTimestamp(),
                tracing.getDistance()
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

    private Tracing startTracing(TripStartRequestDto tripStartRequestDto, String orderId) {
        Tracing tracking = new Tracing(
                orderId,
                tripStartRequestDto.getLatitude(), tripStartRequestDto.getLongitude(),
                0d,
                0d,
                LocalDateTime.now()
        );
        tracingRepository.insert(tracking);
        return tracking;
    }
}
