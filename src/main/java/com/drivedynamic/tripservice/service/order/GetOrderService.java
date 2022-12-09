package com.drivedynamic.tripservice.service.order;

import com.drivedynamic.tripservice.model.MongoConfig;
import com.drivedynamic.tripservice.model.Order;
import com.drivedynamic.tripservice.repository.IOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetOrderService {
    private final IOrderRepository orderRepository;

    public Order getOrder(String id) throws Exception {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        return new MongoConfig().mongoTemplate().find(query, Order.class).get(0);
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
