package com.drivedynamic.tripservice.model.trip.status.start;

import com.drivedynamic.tripservice.model.constant.Payment;
import com.drivedynamic.tripservice.model.constant.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class StartResponseDto implements Serializable {
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
