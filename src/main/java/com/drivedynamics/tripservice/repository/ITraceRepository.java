package com.drivedynamics.tripservice.repository;

import com.drivedynamics.tripservice.model.Trace;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITraceRepository extends MongoRepository<Trace, String> {
}