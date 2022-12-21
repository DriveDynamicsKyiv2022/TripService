package com.drivedynamics.tripservice.controller;

import com.drivedynamics.tripservice.model.document.Trace;
import com.drivedynamics.tripservice.model.dto.CoordinatesRequestDto;
import com.drivedynamics.tripservice.service.TraceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Pattern;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/traces")
public class TraceController {
    private final TraceService traceService;

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

    @GetMapping
    public ResponseEntity<?> getCurrentTrace(@Validated @RequestBody CoordinatesRequestDto requestDto) {
        Trace responseBody = traceService.getCurrentTrace(requestDto);
        return ResponseEntity.ok(responseBody);
    }

    @PatchMapping
    public ResponseEntity<?> updateCurrentTrace(@Validated @RequestBody CoordinatesRequestDto requestDto) {
        return traceService.updateCurrentTrace(requestDto);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getTrace(@Pattern(regexp = "[a-z0-9]{1,24}") @PathVariable String id) {
        Trace responseBody = traceService.getTrace(id);
        return ResponseEntity.ok(responseBody);
    }
}
