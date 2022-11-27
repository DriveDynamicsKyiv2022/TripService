package com.example.tripservice.model.trip.finish;

import com.example.tripservice.model.trip.stop.TripStopRequestDto;
import lombok.NonNull;

public class TripFinishRequestDto extends TripStopRequestDto {
    public TripFinishRequestDto(@NonNull String orderId) {
        super(orderId);
    }
}
