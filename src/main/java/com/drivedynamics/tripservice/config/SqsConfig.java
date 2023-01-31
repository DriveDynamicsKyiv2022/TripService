package com.drivedynamics.tripservice.config;

import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class SqsConfig {
    @Bean
    @Profile("!local")
    public AmazonSQS amazonSQS() {
        return AmazonSQSClientBuilder.defaultClient();
    }

    @Bean
    @Profile("local")
    public AmazonSQS localAmazonSQS() {
        return AmazonSQSClientBuilder.standard()
                .withCredentials(new EnvironmentVariableCredentialsProvider())
                .build();
    }
}
