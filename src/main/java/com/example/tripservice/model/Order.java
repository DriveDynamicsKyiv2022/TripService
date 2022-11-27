package com.example.tripservice.model;

import com.example.tripservice.model.constant.Payment;
import com.example.tripservice.model.constant.Status;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Document
public class Order implements Serializable {
    @Id
    private String id;
    @NonNull
    private String userId;
    @NonNull
    private String carId;
    @NonNull
    private LocalDateTime activationTime;
    @Nullable
    private LocalDateTime completionTime;
    @NonNull
    private Double balance;
    @NonNull
    private Status status;
    @NonNull
    private Payment payment;

    public Order(String userId,
                 String carId,
                 LocalDateTime activationTime,
                 LocalDateTime completionTime,
                 Double balance,
                 Status status,
                 Payment payment) {
        this.userId = userId;
        this.carId = carId;
        this.activationTime = activationTime;
        this.completionTime = completionTime;
        this.balance = balance;
        this.status = status;
        this.payment = payment;
    }
}
