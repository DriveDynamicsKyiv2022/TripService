package com.example.tripservice.controller.status;

import com.example.tripservice.model.trip.status.stop.TripStopRequestDto;
import com.example.tripservice.service.status.TripStopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class TripStopController {
    private final TripStopService tripStopService;

    /*
    Example request:
{
   "trafficOrderId" : 45
}

Example response:
HTTP status = "OK"

In the traffic order with trafficOrderId status set to “STOP”
     */
    @PatchMapping("/trip/stop")
    public ResponseEntity<?> stopTrip(@RequestBody TripStopRequestDto tripStopRequestdto) {
        var responseBody = tripStopService.stopTrip(tripStopRequestdto);
        return ResponseEntity.ok(responseBody);
    }
}
