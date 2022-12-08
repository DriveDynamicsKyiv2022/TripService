package com.example.tripservice.controller.status;

import com.example.tripservice.model.trip.status.finish.TripFinishRequestDto;
import com.example.tripservice.service.status.TripFinishService;
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
        return tripFinishService.finishTrip(tripFinishRequestdto);
    }
}
