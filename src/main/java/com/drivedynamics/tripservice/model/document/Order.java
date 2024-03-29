package com.drivedynamics.tripservice.model.document;

import com.drivedynamics.tripservice.model.constant.Payment;
import com.drivedynamics.tripservice.model.constant.Status;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Document(collection = "orders")
public final class Order implements Serializable {
    private static final long serialVersionUID = 4L;
    @Id
    private String id;
    @NonNull
    private Long userId;
    @NonNull
    private Long carId;
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

    public Order(Long userId,
                 Long carId,
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
