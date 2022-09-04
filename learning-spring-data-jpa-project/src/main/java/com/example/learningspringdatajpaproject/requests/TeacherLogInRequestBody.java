package com.example.learningspringdatajpaproject.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherLogInRequestBody {

    private String email;
    private String password;
}
