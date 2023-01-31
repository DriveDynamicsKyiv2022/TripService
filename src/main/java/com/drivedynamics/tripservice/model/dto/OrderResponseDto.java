package com.drivedynamics.tripservice.model.dto;

import com.drivedynamics.tripservice.model.document.Order;
import com.drivedynamics.tripservice.model.document.Trace;
import com.drivedynamics.tripservice.model.constant.Payment;
import com.drivedynamics.tripservice.model.constant.Status;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public final class OrderResponseDto implements Serializable {
    private static final long serialVersionUID = 1L;
    @NonNull
    private String id;
    @NonNull
    private String ownerId;
    @NonNull
    private long userId;
    @NonNull
    private long carId;
    @NonNull
    private LocalDateTime activationTime;
    @NonNull
    private Status status;
    @NonNull
    private Payment statusPaid;
    @NonNull
    private Double balance;
    @NonNull
    private String traceId;
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

    public OrderResponseDto(
            String id, String ownerId, OrderRequestDto orderRequestDto, Order order, Trace trace) {//TODO mock car service, get car owner's userId
        this.id = id;
        this.ownerId = ownerId;
        this.userId = orderRequestDto.getUserId();
        this.carId = orderRequestDto.getCarId();
        this.activationTime = order.getActivationTime();
        this.status = order.getStatus();
        this.statusPaid = order.getPayment();
        this.balance = order.getBalance();
        this.traceId = trace.getId();
        this.latitude = trace.getLatitude();
        this.longitude = trace.getLongitude();
        this.speed = trace.getSpeed();
        this.timestamp = trace.getTimestamp();
        this.distance = trace.getDistance();
    }
}
