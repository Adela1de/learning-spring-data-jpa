package com.example.learningspringdatajpaproject.services;

import com.example.learningspringdatajpaproject.entities.Guardian;
import com.example.learningspringdatajpaproject.entities.Student;

public interface StudentService {

    Student saveStudent(Student student);

    Guardian setGuardianToStudent(Long studentId, Long guardianId);

    Student getStudentById(Long studentId);

    Guardian getGuardianById(Long guardianId);

}
