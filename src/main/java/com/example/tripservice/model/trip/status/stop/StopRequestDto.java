package com.example.tripservice.model.trip.status.stop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class StopRequestDto {
    /*
    trafficOrderId - mandatory (trafficOrderId > 1)
     */
    @NonNull
    private String orderId;
}
