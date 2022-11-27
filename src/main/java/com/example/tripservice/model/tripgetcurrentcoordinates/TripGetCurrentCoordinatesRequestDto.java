package com.example.tripservice.model.tripgetcurrentcoordinates;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.lang.NonNull;

@Data
@AllArgsConstructor
public class TripGetCurrentCoordinatesRequestDto {
    /*latitude -mandatory (range -90 to 90)
    longitude - mandatory (range -180 to 180)
     */
    @NonNull
    private Double latitude;
    @NonNull
    private Double longitude;
}
