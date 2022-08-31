package com.example.learningspringdatajpaproject.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentLogInRequestBody {

    private String email;
    private String password;
}
