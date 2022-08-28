package com.example.learningspringdatajpaproject.exceptions;

public class StudentIsAlreadyTakingACourseException extends RuntimeException{
    public StudentIsAlreadyTakingACourseException() {
    }

    public StudentIsAlreadyTakingACourseException(String message) {
        super(message);
    }
}
