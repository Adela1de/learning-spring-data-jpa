package com.example.learningspringdatajpaproject.exceptions;

public class WrongTypeException extends RuntimeException{
    public WrongTypeException() {
    }

    public WrongTypeException(String message) {
        super(message);
    }
}
