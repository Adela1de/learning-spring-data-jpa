package com.example.learningspringdatajpaproject.exceptions;

public class StudentIsAlreadyTakingACourse extends RuntimeException{
    public StudentIsAlreadyTakingACourse() {
    }

    public StudentIsAlreadyTakingACourse(String message) {
        super(message);
    }
}
