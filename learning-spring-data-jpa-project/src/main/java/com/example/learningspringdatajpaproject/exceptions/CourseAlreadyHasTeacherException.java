package com.example.learningspringdatajpaproject.exceptions;

public class CourseAlreadyHasTeacherException extends RuntimeException{
    public CourseAlreadyHasTeacherException() {
    }

    public CourseAlreadyHasTeacherException(String message) {
        super(message);
    }
}
