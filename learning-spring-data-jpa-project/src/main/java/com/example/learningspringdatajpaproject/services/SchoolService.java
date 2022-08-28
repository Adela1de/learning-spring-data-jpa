package com.example.learningspringdatajpaproject.services;

import com.example.learningspringdatajpaproject.entities.Course;
import com.example.learningspringdatajpaproject.entities.Guardian;
import com.example.learningspringdatajpaproject.entities.Student;

public interface SchoolService {

    Student saveStudent(Student student);

    Guardian saveGuardian(Guardian guardian);

    Course saveCourse(Course course);

    Guardian assignGuardianToStudent(Long studentId, Long guardianId);

    Student assignStudentToACourse(Long studentId, Long courseId);

    Student getStudentById(Long studentId);

    Guardian getGuardianById(Long guardianId);

    Course getCourseById(Long CourseId);

}
