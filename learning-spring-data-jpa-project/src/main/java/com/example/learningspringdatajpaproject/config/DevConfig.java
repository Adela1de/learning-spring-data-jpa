package com.example.learningspringdatajpaproject.config;

import com.example.learningspringdatajpaproject.database.ObjectCreationForTests;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@RequiredArgsConstructor
@Profile("dev")
public class DevConfig {

    private final ObjectCreationForTests objectCreationForTests;
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddlAuto;

    @Bean
    public void databaseInitialization()
    {
        if(ddlAuto.equalsIgnoreCase("create")) objectCreationForTests.databaseInit();
    }

}
