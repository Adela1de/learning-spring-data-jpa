package com.example.learningspringdatajpaproject.events.listeners;

import com.example.learningspringdatajpaproject.events.RegistrationEvent;
import com.example.learningspringdatajpaproject.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Component
public class RegistrationEventListener implements ApplicationListener<RegistrationEvent> {

    private final UserService userService;

    @Override
    public void onApplicationEvent(RegistrationEvent event) {
        var token = UUID.randomUUID().toString();
        var user = event.getUser();
        userService.saveVerificationTokenForUser(user, token);

        var urlConfirmation = event.getUrl() + "/users/confirmRegistration?token=" + token;
        log.info("Click the link to enable your account " + urlConfirmation);
    }
}
