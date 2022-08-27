package com.example.learningspringdatajpaproject.exceptions;

public class GuardianAlreadyHasStudentException extends RuntimeException{
    public GuardianAlreadyHasStudentException() {
    }

    public GuardianAlreadyHasStudentException(String message) {
        super(message);
    }
}
