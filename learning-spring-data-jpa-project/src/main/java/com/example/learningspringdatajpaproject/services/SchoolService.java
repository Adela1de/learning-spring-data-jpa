package com.example.learningspringdatajpaproject.services;

import com.example.learningspringdatajpaproject.entities.*;

import java.util.List;

public interface SchoolService {

    Guardian saveGuardian(Guardian guardian);

    Course saveCourse(Course course);

    CourseMaterial saveCourseMaterial(CourseMaterial courseMaterial);

    CourseClass saveCourseClass(CourseClass courseClass);

    Guardian assignGuardianToStudent(Long studentId, Long guardianId);

    Student assignStudentToACourse(Long studentId, Long courseId);

    Course assignCourseMaterialToCourse(Long courseId, Long courseMaterialId);

    CourseClass assignCourseClassToCourse(Long courseId, Long courseClassId);

    CourseClass assignStudentToCourseClass(Long studentId, Long courseClassId);

    Student assignGradeToClass(Long studentId, Long courseClassId, CourseClassStudentGrade grade);

    Student getStudentById(Long studentId);

    Guardian getGuardianById(Long guardianId);

    Course getCourseById(Long courseId);

    Teacher getTeacherById(Long teacherId);

    CourseMaterial getCourseMaterialById(Long courseMaterialId);

    CourseClass getCourseClassById(Long courseClassId);

    List<Course> getAllCourses();

    List<CourseClass> getAllCourseClassesInACourseByTitle(String courseTitle);

    List<CourseClass> getAllCourseClassesOfAStudent(Long studentId);

}
