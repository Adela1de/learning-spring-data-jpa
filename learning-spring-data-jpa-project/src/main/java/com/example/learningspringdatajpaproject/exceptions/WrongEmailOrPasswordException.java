package com.example.learningspringdatajpaproject.exceptions;

public class WrongEmailOrPasswordException extends RuntimeException{
    public WrongEmailOrPasswordException() {
    }

    public WrongEmailOrPasswordException(String message) {
        super(message);
    }
}
