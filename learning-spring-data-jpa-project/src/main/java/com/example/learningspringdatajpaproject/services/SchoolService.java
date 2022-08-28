package com.example.learningspringdatajpaproject.services;

import com.example.learningspringdatajpaproject.entities.Course;
import com.example.learningspringdatajpaproject.entities.Guardian;
import com.example.learningspringdatajpaproject.entities.Student;
import com.example.learningspringdatajpaproject.entities.Teacher;

public interface SchoolService {

    Student saveStudent(Student student);

    Guardian saveGuardian(Guardian guardian);

    Course saveCourse(Course course);

    Teacher saveTeacher(Teacher teacher);

    Guardian assignGuardianToStudent(Long studentId, Long guardianId);

    Student assignStudentToACourse(Long studentId, Long courseId);

    Course assignTeacherToCourse(Long teacherId, Long CourseId);

    Student getStudentById(Long studentId);

    Guardian getGuardianById(Long guardianId);

    Course getCourseById(Long courseId);

    Teacher getTeacherById(Long teacherId);

}
