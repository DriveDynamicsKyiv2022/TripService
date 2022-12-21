package com.drivedynamics.tripservice.service;

import com.drivedynamics.tripservice.config.MongoConfig;
import com.drivedynamics.tripservice.model.document.Trace;
import com.drivedynamics.tripservice.model.dto.CoordinatesRequestDto;
import com.drivedynamics.tripservice.repository.ITraceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TraceService {
    private final ITraceRepository traceRepository;
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
    public Trace getTrace(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        return mongoConfig.mongoTemplate().find(query, Trace.class).get(0);
    }

    public Trace getCurrentTrace(CoordinatesRequestDto requestDto) {
        return new Trace(
                "1",
                0d, 0d,
                0d,
                0d,
                LocalDateTime.now()
        );
    }

    public ResponseEntity updateCurrentTrace(CoordinatesRequestDto coordinatesRequestDto) {
        return ResponseEntity.ok().build();
    }

}
