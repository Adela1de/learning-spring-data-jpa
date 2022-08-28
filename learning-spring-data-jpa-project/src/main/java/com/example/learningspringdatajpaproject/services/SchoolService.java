package com.example.learningspringdatajpaproject.services;

import com.example.learningspringdatajpaproject.entities.*;

public interface SchoolService {

    Student saveStudent(Student student);

    Guardian saveGuardian(Guardian guardian);

    Course saveCourse(Course course);

    Teacher saveTeacher(Teacher teacher);

    CourseMaterial saveCourseMaterial(CourseMaterial courseMaterial);

    CourseClass saveCourseClass(CourseClass courseClass);

    Guardian assignGuardianToStudent(Long studentId, Long guardianId);

    Student assignStudentToACourse(Long studentId, Long courseId);

    Course assignTeacherToCourse(Long teacherId, Long courseId);

    Course assignCourseMaterialToCourse(Long courseId, Long courseMaterialId);

    CourseClass assignCourseClassToCourse(Long courseId, Long courseClassId);

    Student getStudentById(Long studentId);

    Guardian getGuardianById(Long guardianId);

    Course getCourseById(Long courseId);

    Teacher getTeacherById(Long teacherId);

    CourseMaterial getCourseMaterialById(Long courseMaterialId);

    CourseClass getCourseClassById(Long courseClassId);

}
