package com.example.learningspringdatajpaproject.exceptions;

public class InvalidTokenException extends RuntimeException{
    public InvalidTokenException() {
    }

    public InvalidTokenException(String message) {
        super(message);
    }
}
