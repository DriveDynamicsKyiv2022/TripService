package com.drivedynamic.tripservice.controller.status;

import com.drivedynamic.tripservice.model.trip.status.stop.StopRequestDto;
import com.drivedynamic.tripservice.model.trip.status.stop.StopResponseDto;
import com.drivedynamic.tripservice.service.status.StopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StopController {
    private final StopService stopService;

    /*
    TODO
    Example request:
{
   "trafficOrderId" : 45
}

Example response:
HTTP status = "OK"

In the traffic order with trafficOrderId status set to “STOP”
     */
    @PatchMapping("/trip/stop")
    public ResponseEntity<?> stopTrip(@RequestBody StopRequestDto stopRequestdto) {
        StopResponseDto responseBody = stopService.stopTrip(stopRequestdto);
        return ResponseEntity.ok(responseBody);
    }
}
