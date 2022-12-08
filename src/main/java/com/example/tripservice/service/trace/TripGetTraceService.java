package com.example.tripservice.service.trace;

import com.example.tripservice.model.Tracing;
import com.example.tripservice.repository.ITracingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TripGetTraceService {

    private final ITracingRepository tracingRepository;

    @Autowired
    public TripGetTraceService(ITracingRepository tracingRepository) {
        this.tracingRepository = tracingRepository;
    }

    public Tracing getTrace(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        return new Tracing(
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