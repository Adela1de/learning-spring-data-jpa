package com.example.learningspringdatajpaproject.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserTeacherDTO {

    private Long userId;
    private String firstName;
    private String lastName;
    private String role;
}
