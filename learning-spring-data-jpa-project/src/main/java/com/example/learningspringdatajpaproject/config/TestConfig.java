package com.example.learningspringdatajpaproject.config;

import com.example.learningspringdatajpaproject.database.ObjectCreationForTests;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@RequiredArgsConstructor
@Profile("test")
public class TestConfig {

    private final ObjectCreationForTests objectCreationForTests;

    @Bean
    public void databaseInitialization(){ objectCreationForTests.databaseInit(); }
}
