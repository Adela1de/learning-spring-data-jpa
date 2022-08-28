package com.example.learningspringdatajpaproject.controllers.Exception;

import com.example.learningspringdatajpaproject.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.ServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException e, ServletRequest s)
    {
        var error = new StandardError(HttpStatus.NOT_FOUND.value(), System.currentTimeMillis(), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(GuardianAlreadyHasStudentException.class)
    public ResponseEntity<StandardError> guardianAlreadyHasStudentException(GuardianAlreadyHasStudentException e,
                                                                            ServletRequest s)
    {
        var error = new StandardError(HttpStatus.BAD_REQUEST.value(), System.currentTimeMillis(), e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(StudentIsAlreadyTakingACourseException.class)
    public ResponseEntity<StandardError> studentIsAlreadyTakingACourse(StudentIsAlreadyTakingACourseException e,
                                                                       ServletRequest s)
    {
        var error = new StandardError(HttpStatus.BAD_REQUEST.value(), System.currentTimeMillis(), e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(CourseAlreadyHasTeacherException.class)
    public ResponseEntity<StandardError> courseAlreadyHasTeacherException(CourseAlreadyHasTeacherException e,
                                                                       ServletRequest s)
    {
        var error = new StandardError(HttpStatus.BAD_REQUEST.value(), System.currentTimeMillis(), e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(InvalidClassException.class)
    public ResponseEntity<StandardError> invalidClassException(InvalidClassException e,
                                                               ServletRequest s)
    {
        var error = new StandardError(HttpStatus.BAD_REQUEST.value(), System.currentTimeMillis(), e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
