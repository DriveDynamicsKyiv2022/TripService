package com.drivedynamic.tripservice.model.trip.status.start;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class StartRequestDto implements Serializable {
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
