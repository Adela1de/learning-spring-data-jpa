package com.example.learningspringdatajpaproject.services.Impl;

import com.example.learningspringdatajpaproject.entities.Course;
import com.example.learningspringdatajpaproject.entities.Guardian;
import com.example.learningspringdatajpaproject.entities.Student;
import com.example.learningspringdatajpaproject.exceptions.GuardianAlreadyHasStudentException;
import com.example.learningspringdatajpaproject.exceptions.ObjectNotFoundException;
import com.example.learningspringdatajpaproject.repositories.CourseRepository;
import com.example.learningspringdatajpaproject.repositories.GuardianRepository;
import com.example.learningspringdatajpaproject.repositories.StudentRepository;
import com.example.learningspringdatajpaproject.services.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService {

    private final StudentRepository studentRepository;
    private final GuardianRepository guardianRepository;
    private final CourseRepository courseRepository;

    @Override
    public Student saveStudent(Student student) { return studentRepository.save(student); }

    @Override
    public Guardian saveGuardian(Guardian guardian) { return guardianRepository.save(guardian); }

    @Override
    public Course saveCourse(Course course) { return courseRepository.save(course); }

    @Override
    public Guardian assignGuardianToStudent(Long studentId, Long guardianId) {
        var student = findStudentByIdOrElseThrowException(studentId);
        var guardian = findGuardianByIdOrElseThrowException(guardianId);

        if(verifyIfGuardianAlreadyHasAStudent(guardian))
            throw new GuardianAlreadyHasStudentException("This guardian already has a student assigned! ");

        guardian.setStudent(student);
        return guardianRepository.save(guardian);
    }

    @Override
    public Student assignStudentToAStudent(Long studentId, Long courseId) {
        return null;
    }

    @Override
    public Student getStudentById(Long studentId) {
        return findStudentByIdOrElseThrowException(studentId);
    }

    @Override
    public Guardian getGuardianById(Long guardianId) {
        return findGuardianByIdOrElseThrowException(guardianId);
    }

    @Override
    public Course getCourseById(Long CourseId) {
        return null;
    }

    private Student findStudentByIdOrElseThrowException(Long studentId)
    {
        return studentRepository.findById(studentId).orElseThrow(
                () -> new ObjectNotFoundException("Student not found!")
        );
    }

    private Guardian findGuardianByIdOrElseThrowException(Long guardianId)
    {
        return guardianRepository.findById(guardianId).orElseThrow(
                () -> new ObjectNotFoundException("Guardian not found!")
        );
    }

    private boolean verifyIfGuardianAlreadyHasAStudent(Guardian guardian) {
        if(guardian.getStudent() != null) return true;
        return false;
    }
}