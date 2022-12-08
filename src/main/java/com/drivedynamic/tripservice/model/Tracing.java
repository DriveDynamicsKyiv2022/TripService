package com.drivedynamic.tripservice.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Document
public class Tracing implements Serializable {
    @Id
    private String id;
    @NonNull
    private String orderId;
    @NonNull
    private Double latitude;
    @NonNull
    private Double longitude;
    @NonNull
    private Double speed;
    @NonNull
    private Double distance;
    @NonNull
    private LocalDateTime timestamp;

    public Tracing(String orderId,
                   Double latitude,
                   Double longitude,
                   Double speed,
                   Double distance,
                   LocalDateTime timestamp) {
        this.orderId = orderId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.speed = speed;
        this.distance = distance;
        this.timestamp = timestamp;
    }
}
