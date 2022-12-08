package com.drivedynamic.tripservice.service.status;

import com.drivedynamic.tripservice.model.Order;
import com.drivedynamic.tripservice.model.Tracing;
import com.drivedynamic.tripservice.model.constant.Payment;
import com.drivedynamic.tripservice.model.constant.Status;
import com.drivedynamic.tripservice.model.trip.status.start.StartRequestDto;
import com.drivedynamic.tripservice.model.trip.status.start.StartResponseDto;
import com.drivedynamic.tripservice.repository.IOrderRepository;
import com.drivedynamic.tripservice.repository.ITracingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class StartService {

    private final IOrderRepository orderRepository;
    private final ITracingRepository tracingRepository;

    public StartResponseDto startTrip(StartRequestDto startRequestDto) {
//        carId >= 1
//        userId >= 1
//        Balance >= 10
//        Latitude range (-90 to 90)
//        Longitude range (-180 to 180)

        Order order = createOrder(startRequestDto);
        Tracing tracing = startTracing(startRequestDto, order.getId());
        return new StartResponseDto(
                //TODO mock car service, get car owner's userId
                "1",
                startRequestDto.getUserId(),
                startRequestDto.getCarId(),
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

    private Order createOrder(StartRequestDto startRequestDto) {
        Order order = new Order(
                startRequestDto.getUserId(),
                startRequestDto.getCarId(),
                LocalDateTime.now(),
                null,
                startRequestDto.getBalance(),
                Status.IN_ORDER,
                Payment.IN_PROCESS
        );
        orderRepository.insert(order);
        return order;
    }

    private Tracing startTracing(StartRequestDto startRequestDto, String orderId) {
        Tracing tracking = new Tracing(
                orderId,
                startRequestDto.getLatitude(), startRequestDto.getLongitude(),
                0d,
                0d,
                LocalDateTime.now()
        );
        tracingRepository.insert(tracking);
        return tracking;
    }
}
