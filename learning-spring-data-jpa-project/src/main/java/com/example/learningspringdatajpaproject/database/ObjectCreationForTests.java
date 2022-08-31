package com.example.learningspringdatajpaproject.database;

import com.example.learningspringdatajpaproject.entities.Course;
import com.example.learningspringdatajpaproject.entities.Guardian;
import com.example.learningspringdatajpaproject.entities.Student;
import com.example.learningspringdatajpaproject.entities.Teacher;
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
        var s1 = new Student("testname1", "testlastname1", "testeemail1@gmail.com", "00000000");
        var s2 = new Student("testname2", "testlastname2", "testeemail2@gmail.com", "00000000");
        var s3 = new Student("testname3", "testlastname3", "testeemail3@gmail.com", "00000000");
        var s4 = new Student("testname4", "testlastname4", "testeemail4@gmail.com", "00000000");
        var s5 = new Student("testname5", "testlastname5", "testeemail5@gmail.com", "00000000");

        var g1 = new Guardian("name1", "mailguardian1@gmail.com","000000000");
        var g2 = new Guardian("name2", "mailguardian2@gmail.com","000000000");
        var g3 = new Guardian("name3", "mailguardian3@gmail.com","000000000");
        var g4 = new Guardian("name4", "mailguardian4@gmail.com","000000000");
        var g5 = new Guardian("name5", "mailguardian5@gmail.com","000000000");

        var c1 = new Course("Course title 1");
        var c2 = new Course("Course title 2");
        var c3 = new Course("Course title 3");
        var c4 = new Course("Course title 4");
        var c5 = new Course("Course title 5");

        var t1 = new Teacher("Name1", "Nastname1");
        var t2 = new Teacher("Name3", "Nastname2");
        var t3 = new Teacher("Name4", "Nastname3");
        var t4 = new Teacher("Name5", "Nastname4");
        var t5 = new Teacher("Name6", "Nastname5");

        studentRepository.saveAll(Arrays.asList(s1, s2, s3, s4, s5));
        guardianRepository.saveAll(Arrays.asList(g1, g2, g3, g4, g5));
        courseRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5));
        teacherRepository.saveAll(Arrays.asList(t1, t2, t3, t4, t5));


    }
}
