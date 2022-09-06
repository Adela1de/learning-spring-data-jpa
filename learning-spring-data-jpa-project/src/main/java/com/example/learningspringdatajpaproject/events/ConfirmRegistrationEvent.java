package com.example.learningspringdatajpaproject.events;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;
@Getter
@Setter
public class ConfirmRegistrationEvent extends ApplicationEvent {

    private String token;
    private String url;

    public ConfirmRegistrationEvent(String token, String url) {
        super(token);
        this.token = token;
        this.url = url;
    }
}
