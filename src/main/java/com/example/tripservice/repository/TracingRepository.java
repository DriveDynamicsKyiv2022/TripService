package com.example.tripservice.repository;

import com.example.tripservice.model.Tracing;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface TracingRepository extends MongoRepository<Tracing, String> {
    Tracing insert(@NonNull Tracing tracing);
}