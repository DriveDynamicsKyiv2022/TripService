package com.drivedynamics.tripservice.utils;

import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;
import com.amazonaws.services.lambda.model.ServiceException;
import com.drivedynamics.tripservice.model.document.Order;
import com.griddynamics.car.enums.CarBodyStyle;
import com.griddynamics.order.OrderDto;

import java.util.Random;

public class BuildingUtils {
    private static final Random random = new Random();

    public static OrderDto toDto(Order order) {
        return OrderDto.builder()
                .carId(order.getCarId())
                .orderId(order.getId())
                .userId(order.getUserId())
                .carBodyStyle(CarBodyStyle.values()[random.nextInt(CarBodyStyle.values().length - 1)])
                .endDateTime(order.getCompletionTime())
                .startDateTime(order.getActivationTime())
                .price(order.getBalance())
                .tariffId(getRandomTariffId())
                .build();
    }

    private static String getRandomTariffId() {
        try {
            InvokeRequest invokeRequest = new InvokeRequest()
                    .withFunctionName("get-tariff-lambda");
            AWSLambda lambda = AWSLambdaClientBuilder.defaultClient();
            InvokeResult invokeResult = lambda.invoke(invokeRequest);
            String result = new String(invokeResult.getPayload().array());
            result = result.replace('"', '\0');
            System.out.println("--------" + result);
            return result;
        } catch (ServiceException e) {
            throw new RuntimeException("Problems with connectivity");
        }
    }
}
