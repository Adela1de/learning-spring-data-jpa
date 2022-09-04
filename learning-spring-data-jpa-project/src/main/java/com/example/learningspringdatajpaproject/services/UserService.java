package com.example.learningspringdatajpaproject.services;

import com.example.learningspringdatajpaproject.entities.Student;
import com.example.learningspringdatajpaproject.entities.Teacher;

public interface UserService {

    Student registerStudent(Student student);

    Teacher registerTeacher(Teacher teacher);

    Student logInStudent(String studentEmail, String studentPassword);

    Teacher logInTeacher(String teacherEmail, String teacherPassword);
}
