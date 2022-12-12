package com.drivedynamics.tripservice.controller;

import com.drivedynamics.tripservice.model.Tracing;
import com.drivedynamics.tripservice.model.trip.currentcoordinates.get.GetCurrentCoordinatesRequestDto;
import com.drivedynamics.tripservice.model.trip.currentcoordinates.update.UpdateCurrentCoordinatesRequestDto;
import com.drivedynamics.tripservice.service.TracingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Pattern;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/trip/trace")
public class TracingController {
    private final TracingService tracingService;

    /*
    TODO
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
        /*
    TODO
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

    //-----

    @GetMapping("/current")
    public ResponseEntity<?> getCurrentTrace(@Validated @RequestBody GetCurrentCoordinatesRequestDto requestDto) {
        Tracing responseBody = tracingService.getCurrentTrace(requestDto);
        return ResponseEntity.ok(responseBody);
    }

    @PostMapping("/current/update")
    public ResponseEntity<?> updateCurrentTrace(@Validated @RequestBody UpdateCurrentCoordinatesRequestDto requestDto) {
        return tracingService.updateCurrentTrace(requestDto);
    }

    @GetMapping("/")
    public ResponseEntity<?> getTrace(@Pattern(regexp = "[a-z0-9]{1,24}") @RequestParam String id) throws Exception {
        Tracing responseBody = tracingService.getTrace(id);
        return ResponseEntity.ok(responseBody);
    }
}
