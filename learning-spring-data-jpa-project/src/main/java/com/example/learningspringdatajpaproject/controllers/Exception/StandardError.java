package com.example.learningspringdatajpaproject.controllers.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StandardError {

    private Integer status;
    private Long timestamp;
    private String message;
}
