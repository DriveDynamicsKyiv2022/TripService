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

    @PatchMapping("/trip/finish")
    public ResponseEntity<?> finishTrip(@RequestBody FinishRequestDto finishRequestdto) throws Exception {
        return finishService.finishTrip(finishRequestdto);
    }
}
