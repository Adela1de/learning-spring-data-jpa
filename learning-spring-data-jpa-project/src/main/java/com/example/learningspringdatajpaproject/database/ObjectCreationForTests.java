package com.example.learningspringdatajpaproject.database;

import com.example.learningspringdatajpaproject.entities.Student;
import com.example.learningspringdatajpaproject.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class ObjectCreationForTests {

    private final StudentRepository studentRepository;
    private final GuardianRepository guardianRepository;
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    private final CourseMaterialRepository courseMaterialRepository;
    private final CourseClassRepository courseClassRepository;
    private final CourseClassStudentGradeRepository courseClassStudentGradeRepository;

    public void databaseInit()
    {
        var student1 = new Student("testname1", "testlastname1", "testeemail1@gmail.com");
        var student2 = new Student("testname2", "testlastname2", "testeemail2@gmail.com");
        var student3 = new Student("testname3", "testlastname3", "testeemail3@gmail.com");
        var student4 = new Student("testname4", "testlastname4", "testeemail4@gmail.com");
        var student5 = new Student("testname5", "testlastname5", "testeemail5@gmail.com");

        studentRepository.saveAll(Arrays.asList(student1, student2, student3, student4,student5));
    }
}
