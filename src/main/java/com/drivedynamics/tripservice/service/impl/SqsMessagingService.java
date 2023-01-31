package com.drivedynamics.tripservice.service.impl;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.drivedynamics.tripservice.service.IMessagingService;
import com.drivedynamics.tripservice.service.IParameterService;
import com.drivedynamics.tripservice.utils.JsonUtils;
import com.griddynamics.order.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SqsMessagingService implements IMessagingService {
    private final AmazonSQS amazonSQS;
    private final IParameterService parameterService;

    @Autowired
    public SqsMessagingService(AmazonSQS amazonSQS, IParameterService parameterService) {
        this.amazonSQS = amazonSQS;
        this.parameterService = parameterService;
    }

    @Override
    public void sendOrderToBackoffice(OrderDto orderDto) {
        SendMessageRequest sendMessageRequest = new SendMessageRequest()
                .withQueueUrl(getQueueUrl())
                .withMessageBody(JsonUtils.toJson(orderDto));
        amazonSQS.sendMessage(sendMessageRequest);
    }

    private String getQueueUrl() {
        String queueName = parameterService.getParameter("backoffice-queue-name", false);
        return amazonSQS.getQueueUrl(queueName).getQueueUrl();
    }
}
