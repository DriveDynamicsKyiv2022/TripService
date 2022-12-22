package com.drivedynamics.tripservice.service;

import com.drivedynamics.tripservice.config.MongoConfig;
import com.drivedynamics.tripservice.exception.NoSuchOrderException;
import com.drivedynamics.tripservice.exception.ValidationException;
import com.drivedynamics.tripservice.model.constant.Payment;
import com.drivedynamics.tripservice.model.constant.Status;
import com.drivedynamics.tripservice.model.document.Order;
import com.drivedynamics.tripservice.model.document.Trace;
import com.drivedynamics.tripservice.model.dto.OrderRequestDto;
import com.drivedynamics.tripservice.model.dto.OrderResponseDto;
import com.drivedynamics.tripservice.repository.IOrderRepository;
import com.drivedynamics.tripservice.repository.ITraceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private static final FindAndModifyOptions options = FindAndModifyOptions.options().returnNew(true);
    private final IOrderRepository orderRepository;
    private final ITraceRepository traceRepository;
    private final MongoConfig mongoConfig;

    public OrderResponseDto createOrder(OrderRequestDto orderRequestDto, BindingResult errors) {
        checkValidationErrors(errors);
        Order order = createOrder(orderRequestDto);
        Trace trace = createTrace(orderRequestDto, order.getId());
        //TODO mock car service, get car owner's userId
        return new OrderResponseDto(order.getId(), "1", orderRequestDto, order, trace);
    }

    private Order createOrder(OrderRequestDto orderRequestDto) {
        Order order = new Order(
                orderRequestDto.getUserId(),
                orderRequestDto.getCarId(),
                LocalDateTime.now(),
                null,
                orderRequestDto.getBalance(),
                Status.IN_ORDER,
                Payment.IN_PROCESS
        );
        orderRepository.insert(order);
        return order;
    }

    private Trace createTrace(OrderRequestDto orderRequestDto, String orderId) {
        Trace tracking = new Trace(
                orderId,
                orderRequestDto.getLatitude(), orderRequestDto.getLongitude(),
                0d,
                0d,
                LocalDateTime.now()
        );
        traceRepository.insert(tracking);
        return tracking;
    }

    //TODO
    //Example response (object from DB) - 200 :
    /*
    Example response - 404
{
   "message": "TrafficOrder with id wasn`t found",
   "timestamp": 1659616274765
}
     */

    public Optional<Order> getOrder(String id) {
        return orderRepository.findById(id);
    }

    public Order updateOrder(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        Update update = new Update();
        update.set("status", Status.STOPPED);
        return mongoConfig.mongoTemplate().findAndModify(query, update, options, Order.class);
    }

    public ResponseEntity<?> finishOrder(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        Update update = new Update();
        update.set("completionTime", LocalDateTime.now());
        update.set("status", Status.FINISHED);
        //TODO
        //Calculate balance after trip
        //SEND data to another microservice
        if (mongoConfig.mongoTemplate().findAndModify(query, update, options, Order.class) == null) {
            throw new NoSuchOrderException("There's no order with such id: " + id);
        }
        return ResponseEntity.ok().build();
    }

    private void checkValidationErrors(BindingResult errors) throws ValidationException {
        if (errors.hasErrors()) {
            throw new ValidationException(errors);
        }
    }
}
