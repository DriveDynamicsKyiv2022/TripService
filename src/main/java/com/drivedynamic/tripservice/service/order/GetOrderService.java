package com.drivedynamic.tripservice.service.order;

import com.drivedynamic.tripservice.model.Order;
import com.drivedynamic.tripservice.model.constant.Payment;
import com.drivedynamic.tripservice.model.constant.Status;
import com.drivedynamic.tripservice.repository.IOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class GetOrderService {
    private final IOrderRepository orderRepository;

    public Order getOrder(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
//        return orderRepository.find
        return new Order(
                "1",
                "2",
                LocalDateTime.now(),
                LocalDateTime.now(),
                0d,
                Status.IN_ORDER,
                Payment.IN_PROCESS
        );
    }
//Example response (object from DB) - 200 :

    /*
    Example response - 404
{
   "message": "TrafficOrder with id wasn`t found",
   "timestamp": 1659616274765
}
     */
}
