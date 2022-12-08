package com.drivedynamic.tripservice.model.trip.status.start;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
