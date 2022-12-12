package com.drivedynamics.tripservice.repository;

import com.drivedynamics.tripservice.model.Order;
import com.mongodb.lang.NonNull;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends MongoRepository<Order, String> {
    Order insert(@NonNull Order order);
}