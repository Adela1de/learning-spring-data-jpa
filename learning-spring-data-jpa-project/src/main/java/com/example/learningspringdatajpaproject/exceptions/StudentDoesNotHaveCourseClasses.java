package com.example.learningspringdatajpaproject.exceptions;

public class StudentDoesNotHaveCourseClasses extends RuntimeException{
    public StudentDoesNotHaveCourseClasses() {
    }

    public StudentDoesNotHaveCourseClasses(String message) {
        super(message);
    }
}
