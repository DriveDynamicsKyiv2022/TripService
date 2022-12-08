package com.drivedynamic.tripservice.repository;

import com.drivedynamic.tripservice.model.Tracing;
import com.mongodb.lang.NonNull;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITracingRepository extends MongoRepository<Tracing, String> {
    Tracing insert(@NonNull Tracing tracing);
}