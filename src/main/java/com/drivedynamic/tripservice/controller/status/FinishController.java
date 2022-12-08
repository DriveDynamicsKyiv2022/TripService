package com.drivedynamic.tripservice.controller.status;

import com.drivedynamic.tripservice.model.trip.status.finish.FinishRequestDto;
import com.drivedynamic.tripservice.service.status.FinishService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class FinishController {
    private final FinishService finishService;

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
    public ResponseEntity<?> finishTrip(@RequestBody FinishRequestDto finishRequestdto) {
        return finishService.finishTrip(finishRequestdto);
    }
}
