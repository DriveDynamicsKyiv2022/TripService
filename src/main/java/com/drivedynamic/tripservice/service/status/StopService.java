package com.drivedynamic.tripservice.service.status;

import com.drivedynamic.tripservice.model.trip.status.stop.StopRequestDto;
import com.drivedynamic.tripservice.model.trip.status.stop.StopResponseDto;
import com.drivedynamic.tripservice.repository.IOrderRepository;
import com.drivedynamic.tripservice.repository.ITracingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StopService {

    private final IOrderRepository orderRepository;
    private final ITracingRepository tracingRepository;

    public StopResponseDto stopTrip(StopRequestDto stopRequestDto) {
        return new StopResponseDto();
    }
}