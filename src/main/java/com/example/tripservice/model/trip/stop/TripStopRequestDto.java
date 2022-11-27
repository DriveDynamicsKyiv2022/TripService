package com.example.tripservice.model.trip.stop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class TripStopRequestDto {
    /*
    trafficOrderId - mandatory (trafficOrderId > 1)
     */
    @NonNull
    private String orderId;
}
