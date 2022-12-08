package com.drivedynamic.tripservice.model.trip.currentcoordinates.get;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCurrentCoordinatesRequestDto implements Serializable {
    @NonNull
    @DecimalMin("-90.0")
    @DecimalMax("90.0")
    private Double latitude;
    @NonNull
    @DecimalMin("-180.0")
    @DecimalMax("180.0")
    private Double longitude;
}
