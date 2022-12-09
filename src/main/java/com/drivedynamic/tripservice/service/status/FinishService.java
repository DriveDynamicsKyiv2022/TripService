package com.drivedynamic.tripservice.service.status;

import com.drivedynamic.tripservice.model.MongoConfig;
import com.drivedynamic.tripservice.model.Order;
import com.drivedynamic.tripservice.model.constant.Status;
import com.drivedynamic.tripservice.model.trip.status.finish.FinishRequestDto;
import com.drivedynamic.tripservice.repository.IOrderRepository;
import com.drivedynamic.tripservice.repository.ITracingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class FinishService {

    private final IOrderRepository orderRepository;
    private final ITracingRepository tracingRepository;

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