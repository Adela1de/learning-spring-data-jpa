package com.example.learningspringdatajpaproject.events.listeners;

import com.example.learningspringdatajpaproject.events.ConfirmRegistrationEvent;
import com.example.learningspringdatajpaproject.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public class ConfirmRegistrationEventListener implements ApplicationListener<ConfirmRegistrationEvent> {

    private final UserService userService;

    @Override
    public void onApplicationEvent(ConfirmRegistrationEvent event)
    {
        userService.validateVerificationToken(event.getToken());
    }
}
