package com.drivedynamics.tripservice.service;

import com.drivedynamics.tripservice.config.MongoConfig;
import com.drivedynamics.tripservice.model.Order;
import com.drivedynamics.tripservice.model.Tracing;
import com.drivedynamics.tripservice.model.constant.Payment;
import com.drivedynamics.tripservice.model.constant.Status;
import com.drivedynamics.tripservice.model.trip.status.finish.FinishRequestDto;
import com.drivedynamics.tripservice.model.trip.status.start.StartRequestDto;
import com.drivedynamics.tripservice.model.trip.status.start.StartResponseDto;
import com.drivedynamics.tripservice.model.trip.status.stop.StopRequestDto;
import com.drivedynamics.tripservice.model.trip.status.stop.StopResponseDto;
import com.drivedynamics.tripservice.repository.IOrderRepository;
import com.drivedynamics.tripservice.repository.ITracingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final IOrderRepository orderRepository;
    private final ITracingRepository tracingRepository;

    //TODO
    //Example response (object from DB) - 200 :
    /*
    Example response - 404
{
   "message": "TrafficOrder with id wasn`t found",
   "timestamp": 1659616274765
}
     */

    public Order getOrder(String id) throws Exception {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        return new MongoConfig().mongoTemplate().find(query, Order.class).get(0);
    }

    public StartResponseDto startTrip(StartRequestDto startRequestDto) {
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

    public StopResponseDto stopTrip(StopRequestDto stopRequestDto) throws Exception {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(stopRequestDto.getOrderId()));
        Update update = new Update();
        update.set("status", Status.STOPPED);
        new MongoConfig().mongoTemplate().updateFirst(query, update, Order.class);
        return new StopResponseDto();
    }

    public ResponseEntity finishTrip(FinishRequestDto finishRequestDto) throws Exception {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(finishRequestDto.getOrderId()));
        Update update = new Update();
        update.set("completionTime", LocalDateTime.now());
        update.set("status", Status.FINISHED);
        //TODO
        //Calculate balance after trip
        //SEND data to another microservice
        new MongoConfig().mongoTemplate().updateFirst(query, update, Order.class);
        return ResponseEntity.ok().build();
    }
}
