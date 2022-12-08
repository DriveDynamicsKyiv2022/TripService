package com.drivedynamic.tripservice.model.trip.status.finish;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.Min;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FinishRequestDto implements Serializable {
    @NonNull
    @Min(1)
    private String orderId;

}
