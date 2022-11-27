package com.example.tripservice.service;

import com.example.tripservice.model.Tracking;
import com.example.tripservice.repository.TrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TripGetTrackingService {

    private final TrackingRepository trackingRepository;

    @Autowired
    public TripGetTrackingService(TrackingRepository trackingRepository) {
        this.trackingRepository = trackingRepository;
    }

    public Tracking getTracking(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        return new Tracking(
                "1",
                0d, 0d,
                0d,
                0d,
                LocalDateTime.now()
        );
    }
//Example response (object from DB) - 200 :

    /*
Example response - 404
{
   "message": "Track with id wasn`t found",
   "timestamp": 1659616544946
}

     */
}