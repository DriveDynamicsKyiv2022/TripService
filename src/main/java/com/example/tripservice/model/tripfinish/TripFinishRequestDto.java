package com.example.tripservice.model.tripfinish;

import com.example.tripservice.model.tripstop.TripStopRequestDto;
import lombok.NonNull;

public class TripFinishRequestDto extends TripStopRequestDto {
    public TripFinishRequestDto(@NonNull String orderId) {
        super(orderId);
    }
}
