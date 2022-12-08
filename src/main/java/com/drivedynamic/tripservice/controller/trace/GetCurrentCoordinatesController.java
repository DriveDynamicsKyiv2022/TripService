package com.drivedynamic.tripservice.controller.trace;

import com.drivedynamic.tripservice.model.Tracing;
import com.drivedynamic.tripservice.model.trip.currentcoordinates.get.GetCurrentCoordinatesRequestDto;
import com.drivedynamic.tripservice.service.trace.GetTraceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetCurrentCoordinatesController {

    private final GetTraceService getTraceService;

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
    public ResponseEntity<?> getTracking(@RequestBody GetCurrentCoordinatesRequestDto requestDto) {
        Tracing responseBody = getTraceService.getTrace("1");
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