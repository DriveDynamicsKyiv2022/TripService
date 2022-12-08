package com.example.tripservice.model.trip.status.start;

import com.example.tripservice.model.constant.Payment;
import com.example.tripservice.model.constant.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class StartResponseDto {
    @NonNull
    private String ownerId;
    @NonNull
    private String userId;
    @NonNull
    private String carId;
    @NonNull
    private LocalDateTime activationTime;
    @NonNull
    private Status status;
    @NonNull
    private Payment statusPaid;
    @NonNull
    private double balance;
    @NonNull
    private String trackId;
    @NonNull
    private double latitude;
    @NonNull
    private double longitude;
    @NonNull
    private double speed;
    @NonNull
    private LocalDateTime timestamp;
    @NonNull
    private double distance;
}
