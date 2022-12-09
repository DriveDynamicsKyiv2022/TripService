package com.drivedynamic.tripservice.service.status;

import com.drivedynamic.tripservice.model.MongoConfig;
import com.drivedynamic.tripservice.model.Order;
import com.drivedynamic.tripservice.model.constant.Status;
import com.drivedynamic.tripservice.model.trip.status.stop.StopRequestDto;
import com.drivedynamic.tripservice.model.trip.status.stop.StopResponseDto;
import com.drivedynamic.tripservice.repository.IOrderRepository;
import com.drivedynamic.tripservice.repository.ITracingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StopService {

    private final IOrderRepository orderRepository;
    private final ITracingRepository tracingRepository;

    public StopResponseDto stopTrip(StopRequestDto stopRequestDto) throws Exception {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(stopRequestDto.getOrderId()));
        Update update = new Update();
        update.set("status", Status.STOPPED);
        new MongoConfig().mongoTemplate().updateFirst(query, update, Order.class);
        return new StopResponseDto();
    }
}