package com.drivedynamic.tripservice.model.trip.status.finish;

import com.drivedynamic.tripservice.model.trip.status.stop.StopRequestDto;
import lombok.NonNull;

public class FinishRequestDto extends StopRequestDto {
    public FinishRequestDto(@NonNull String orderId) {
        super(orderId);
    }
}
