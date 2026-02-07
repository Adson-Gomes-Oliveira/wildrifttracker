package com.wildrifttracker.infra.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfiguration {
    @Bean
    public Database mainDatabase(@Value("${database.uri}") String databaseUri) {
        return new Database(databaseUri);
    }
}
