package com.drivedynamic.tripservice.model.trip.status.stop;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class StopRequestDto implements Serializable {
    /*
    trafficOrderId - mandatory (trafficOrderId > 1)
     */
    @NonNull
    private String orderId;
}
