package com.example.tripservice.repository;

import com.example.tripservice.model.Order;
import com.example.tripservice.model.Tracking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackingRepository extends MongoRepository<Tracking, String> {
    Tracking insert(Tracking tracking);
}