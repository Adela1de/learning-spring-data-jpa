package com.example.learningspringdatajpaproject.services;

import com.example.learningspringdatajpaproject.entities.Student;
import com.example.learningspringdatajpaproject.entities.Teacher;
import com.example.learningspringdatajpaproject.entities.User;
import com.example.learningspringdatajpaproject.entities.VerificationToken;

public interface UserService {

    Student registerStudent(Student student);

    Teacher registerTeacher(Teacher teacher);

    User userLogIn(String userEmail, String userPassword);

    VerificationToken saveVerificationTokenForUser(User user, String token);

    VerificationToken findVerificationTokenByToken(String token);

    void validateVerificationToken(String token);
}
