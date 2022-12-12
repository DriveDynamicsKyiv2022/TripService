package com.drivedynamics.tripservice.model.trip.status.start;

import com.drivedynamics.tripservice.model.constant.Payment;
import com.drivedynamics.tripservice.model.constant.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private Double balance;
    @NonNull
    private String trackId;
    @NonNull
    private Double latitude;
    @NonNull
    private Double longitude;
    @NonNull
    private Double speed;
    @NonNull
    private LocalDateTime timestamp;
    @NonNull
    private Double distance;
}
