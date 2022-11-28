package com.example.tripservice.model.trip.status.finish;

import com.example.tripservice.model.trip.status.stop.TripStopRequestDto;
import lombok.NonNull;

public class TripFinishRequestDto extends TripStopRequestDto {
    public TripFinishRequestDto(@NonNull String orderId) {
        super(orderId);
    }
}
