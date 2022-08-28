package com.example.learningspringdatajpaproject.exceptions;

public class InvalidClassException extends RuntimeException{
    public InvalidClassException() {
    }

    public InvalidClassException(String message) {
        super(message);
    }
}
