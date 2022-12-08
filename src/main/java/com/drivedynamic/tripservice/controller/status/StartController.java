package com.drivedynamic.tripservice.controller.status;

import com.drivedynamic.tripservice.model.trip.status.start.StartRequestDto;
import com.drivedynamic.tripservice.model.trip.status.start.StartResponseDto;
import com.drivedynamic.tripservice.service.status.StartService;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.Date;

@RestController
@RequiredArgsConstructor
public class StartController {

    private final StartService startService;

    @PostMapping("/trip/start")
    public ResponseEntity<?> startTrip(@Valid @RequestBody StartRequestDto orderStartRequestdto) {
        StartResponseDto responseBody = startService.startTrip(orderStartRequestdto);
        return ResponseEntity.ok(responseBody);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<String> handleException(MethodArgumentNotValidException e) {
        JsonObject json = new JsonObject();
        json.addProperty("message", "latitude - For latitude, use values in the range -90 to 90;" +
                " longitude - For latitude, use values in the range -180 to 180;" +
                " balance - Balance must have more than 10 hryvnias on the account; ");
        json.addProperty("timestamp", new Timestamp(new Date().getTime()).getTime());
        return ResponseEntity.badRequest().body(json.toString());
    }
}