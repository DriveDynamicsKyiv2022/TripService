package com.drivedynamic.tripservice.model.trip.status.finish;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class FinishRequestDto implements Serializable {
    /*
trafficOrderId - mandatory (trafficOrderId > 1)
 */
    @NonNull
    private String orderId;

}
