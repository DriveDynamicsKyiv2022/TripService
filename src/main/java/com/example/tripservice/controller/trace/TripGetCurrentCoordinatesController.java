package com.example.tripservice.controller.trace;

import com.example.tripservice.model.Tracing;
import com.example.tripservice.model.trip.currentcoordinates.get.TripGetCurrentCoordinatesRequestDto;
import com.example.tripservice.service.trace.TripGetTraceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TripGetCurrentCoordinatesController {

    private final TripGetTraceService tripGetTraceService;

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
    @GetMapping("/trip/trace/current")
    public ResponseEntity<?> getTracking(@RequestBody TripGetCurrentCoordinatesRequestDto requestDto) {
        Tracing responseBody = tripGetTraceService.getTrace("1");
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