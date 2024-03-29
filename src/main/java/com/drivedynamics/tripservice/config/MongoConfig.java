package com.drivedynamics.tripservice.config;

import com.drivedynamics.tripservice.model.constant.ApplicationStrings;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Objects;

@Configuration
@EnableMongoRepositories(basePackages = ApplicationStrings.PACKAGE_REPOSITORY)
public class MongoConfig {

    private final Environment env;

    @Autowired
    public MongoConfig(Environment env) {
        this.env = env;
    }

    @Bean
    public MongoClient mongo() {
        ConnectionString connectionString = new ConnectionString(
                Objects.requireNonNull(
                        env.getProperty(
                                ApplicationStrings.PROPERTY_NAME_SPRING_DATA_MONGODB_URI
                        )
                )
        );
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(
                mongo(),
                Objects.requireNonNull(
                        env.getProperty(
                                ApplicationStrings.PROPERTY_NAME_SPRING_DATA_MONGODB_DATABASE
                        )
                )
        );
    }
}