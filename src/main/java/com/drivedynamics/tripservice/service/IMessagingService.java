package com.drivedynamics.tripservice.service;

import com.griddynamics.order.OrderDto;

public interface IMessagingService {
    void sendOrderToBackoffice(OrderDto orderDto);
}
