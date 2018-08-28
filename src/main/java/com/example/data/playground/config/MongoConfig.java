package com.example.data.playground.config;


import java.io.IOException;
import cz.jirutka.spring.embedmongo.EmbeddedMongoFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.*;
import com.mongodb.MongoClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.example.data.playground.mongo")
public class MongoConfig {
    @Value("${mongo.host}")
    private String mongoHost;
    @Value("${mongo.db}")
    private String mongoDb;

    @Bean
    public MongoTemplate mongoTemplate() throws IOException {
        EmbeddedMongoFactoryBean mongo = new EmbeddedMongoFactoryBean();
        mongo.setBindIp(mongoHost);
        MongoClient mongoClient = mongo.getObject();
        MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, mongoDb);
        return mongoTemplate;
    }
}
