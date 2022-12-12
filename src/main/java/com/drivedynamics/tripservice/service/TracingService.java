package com.drivedynamics.tripservice.service;

import com.drivedynamics.tripservice.config.MongoConfig;
import com.drivedynamics.tripservice.model.Tracing;
import com.drivedynamics.tripservice.model.trip.currentcoordinates.get.GetCurrentCoordinatesRequestDto;
import com.drivedynamics.tripservice.model.trip.currentcoordinates.update.UpdateCurrentCoordinatesRequestDto;
import com.drivedynamics.tripservice.repository.ITracingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TracingService {
    private final ITracingRepository tracingRepository;
    private final MongoConfig mongoConfig;

    //TODO
    //Example response (object from DB) - 200 :

    /*
Example response - 404
{
   "message": "Track with id wasn`t found",
   "timestamp": 1659616544946
}
     */
    public Tracing getTrace(String id) throws Exception {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        return mongoConfig.mongoTemplate().find(query, Tracing.class).get(0);
    }

    public Tracing getCurrentTrace(GetCurrentCoordinatesRequestDto getCurrentCoordinatesRequestDto) {
        return new Tracing(
                "1",
                0d, 0d,
                0d,
                0d,
                LocalDateTime.now()
        );
    }

    public ResponseEntity updateCurrentTrace(UpdateCurrentCoordinatesRequestDto requestDto) {
        return ResponseEntity.ok().build();
    }

}
