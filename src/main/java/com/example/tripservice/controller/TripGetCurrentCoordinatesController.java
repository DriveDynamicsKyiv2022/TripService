package com.example.tripservice.controller;

import com.example.tripservice.model.trip.getcurrentcoordinates.TripGetCurrentCoordinatesRequestDto;
import com.example.tripservice.service.TripGetTrackingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TripGetCurrentCoordinatesController {

    private final TripGetTrackingService tripGetTrackingService;

    /*
    Example request - 200:
{
   "latitude" : -10,
   "longitude" : -100
}

Example Response - 200:
{
   "id": 50,
   "latitude": -10.0,
   "longitude": -100.0,
   "speed": 0,
   "timestamp": "2022-08-04T15:40:31.555221",
   "distance": 0.0
}
     */
    @GetMapping("/trip/track/current")
    public ResponseEntity<?> getTracking(@RequestBody TripGetCurrentCoordinatesRequestDto requestDto) {
        var responseBody = tripGetTrackingService.getTracking("1");
        return ResponseEntity.ok(responseBody);
    }

    /*
    Example request - 404 :
{
   "latitude" : -10,
   "longitude" : -190
}

Example Response - 404:
{
   "message": "longitude - For latitude, use values in the range -180 to 180; ",
   "timestamp": 1659616862903
}
     */
}