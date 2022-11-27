package com.example.tripservice.controller;

import com.example.tripservice.model.tripfinish.TripFinishRequestDto;
import com.example.tripservice.service.TripFinishService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class TripFinishController {
    private final TripFinishService tripFinishService;

    /*
    URL: trip/finish
Body:
trafficOrderId - mandatory (trafficOrderId > 1)

Example request:
{
   "trafficOrderId" : 45
}
Example response:
HTTP status = "OK"
In the traffic order with trafficOrderId :
Status set to “FINISH”
Set Completion time
Calculate balance after trip
SEND data to another microservice

     */
    @PatchMapping("/trip/finish")
    public ResponseEntity<?> finishTrip(@RequestBody TripFinishRequestDto tripFinishRequestdto) {
        var responseBody = tripFinishService.finishTrip(tripFinishRequestdto);
        return ResponseEntity.ok(responseBody);
    }
}
