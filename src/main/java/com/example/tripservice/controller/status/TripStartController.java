package com.example.tripservice.controller.status;

import com.example.tripservice.model.trip.status.start.TripStartRequestDto;
import com.example.tripservice.service.status.TripStartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TripStartController {

    private final TripStartService tripStartService;

    @PostMapping("/trip/start")
    public ResponseEntity<?> startTrip(@RequestBody TripStartRequestDto orderStartRequestdto) {
        var responseBody = tripStartService.startTrip(orderStartRequestdto);
        return ResponseEntity.ok(responseBody);
    }

    /*
    Example request with error :
{
   "carId" : 8,
   "userId" : 8,
   "balance" : 5,
   "latitude" : 190,
   "longitude" : 280
}

Example response with error:
{
   "message": "latitude - For latitude, use values in the range -90 to 90; longitude - For latitude, use values in the range -180 to 180; balance - Balance must have more than 10 hryvnias on the account; ",
   "timestamp": 1659616057678
}
     */
}
