package com.drivedynamics.tripservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class CoordinatesRequestDto implements Serializable {
    private static final long serialVersionUID = 3L;
    @NonNull
    @DecimalMin("-90.0")
    @DecimalMax("90.0")
    private Double latitude;
    @NonNull
    @DecimalMin("-180.0")
    @DecimalMax("180.0")
    private Double longitude;
}
