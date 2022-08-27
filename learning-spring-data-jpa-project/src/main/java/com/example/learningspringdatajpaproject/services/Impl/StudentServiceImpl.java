package com.example.learningspringdatajpaproject.services.Impl;

import com.example.learningspringdatajpaproject.entities.Guardian;
import com.example.learningspringdatajpaproject.entities.Student;
import com.example.learningspringdatajpaproject.repositories.GuardianRepository;
import com.example.learningspringdatajpaproject.repositories.StudentRepository;
import com.example.learningspringdatajpaproject.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final GuardianRepository guardianRepository;

    @Override
    public Student saveStudent(Student student) { return studentRepository.save(student); }

    @Override
    public Guardian setGuardianToStudent(Long studentId, Long guardianId) {
        var student = findStudentByIdOrElseThrowException(studentId);
        var guardian = findGuardianByIdOrElseThrowException(guardianId);
        guardian.setStudent(student);
        return guardianRepository.save(guardian);
    }

    private Student findStudentByIdOrElseThrowException(Long studentId)
    {
        return studentRepository.findById(studentId).orElseThrow(
                () -> new ObjectNotFoundException(Student.class, "Student not found!")
        );
    }

    private Guardian findGuardianByIdOrElseThrowException(Long guardianId)
    {
        return guardianRepository.findById(guardianId).orElseThrow(
                () -> new ObjectNotFoundException(Guardian.class, "Guardian not found!")
        );
    }
}
