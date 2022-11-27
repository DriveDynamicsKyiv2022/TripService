package com.example.tripservice;

import com.example.tripservice.model.Order;
import com.example.tripservice.model.constant.Payment;
import com.example.tripservice.model.constant.Status;
import com.example.tripservice.repository.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class TripServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TripServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(OrderRepository repository) {
        return args -> {
            Order order = new Order(
                    "1",
                    "2",
                    LocalDateTime.now(),
                    LocalDateTime.now(),
                    0d,
                    Status.IN_ORDER,
                    Payment.IN_PROCESS
            );
            repository.insert(order);
        };
    }
}
