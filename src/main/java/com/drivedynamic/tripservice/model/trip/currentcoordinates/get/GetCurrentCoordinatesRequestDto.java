package com.drivedynamic.tripservice.model.trip.currentcoordinates.get;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCurrentCoordinatesRequestDto implements Serializable {
    /*latitude -mandatory (range -90 to 90)
    longitude - mandatory (range -180 to 180)
     */
    @NonNull
    private Double latitude;
    @NonNull
    private Double longitude;
}
