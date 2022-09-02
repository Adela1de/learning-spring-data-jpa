package com.example.learningspringdatajpaproject.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StudentDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String courseTitle;

}
