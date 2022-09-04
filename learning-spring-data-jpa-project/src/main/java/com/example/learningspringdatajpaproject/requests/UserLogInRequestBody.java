package com.example.learningspringdatajpaproject.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLogInRequestBody {

    private String email;
    private String password;
}
