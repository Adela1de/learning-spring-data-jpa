package com.example.learningspringdatajpaproject.services;

import com.example.learningspringdatajpaproject.entities.Student;
import com.example.learningspringdatajpaproject.entities.Teacher;
import com.example.learningspringdatajpaproject.entities.User;

public interface UserService {

    Student registerStudent(Student student);

    Teacher registerTeacher(Teacher teacher);

    <T extends User> T userLogIn(String userEmail, String userPassword);
}
