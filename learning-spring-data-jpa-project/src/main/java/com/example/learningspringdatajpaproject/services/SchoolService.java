package com.example.learningspringdatajpaproject.services;

import com.example.learningspringdatajpaproject.entities.*;

public interface SchoolService {

    Student saveStudent(Student student);

    Guardian saveGuardian(Guardian guardian);

    Course saveCourse(Course course);

    Teacher saveTeacher(Teacher teacher);

    CourseMaterial saveCourseMaterial(CourseMaterial courseMaterial);

    Guardian assignGuardianToStudent(Long studentId, Long guardianId);

    Student assignStudentToACourse(Long studentId, Long courseId);

    Course assignTeacherToCourse(Long teacherId, Long CourseId);

    Course assignCourseMaterialToCourse(Long CourseId, Long CourseMaterialId);

    Student getStudentById(Long studentId);

    Guardian getGuardianById(Long guardianId);

    Course getCourseById(Long courseId);

    Teacher getTeacherById(Long teacherId);

    CourseMaterial getCourseMaterialById(Long CourseMaterialId);

}
