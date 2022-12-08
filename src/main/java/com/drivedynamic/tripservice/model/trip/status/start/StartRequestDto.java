package com.drivedynamic.tripservice.model.trip.status.start;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

@Data
@Document
public class StartRequestDto {
    @NonNull
    private String userId;
    @NonNull
    private String carId;
    @NonNull
    private double balance;
    @NonNull
    private double latitude;
    @NonNull
    private double longitude;
}
