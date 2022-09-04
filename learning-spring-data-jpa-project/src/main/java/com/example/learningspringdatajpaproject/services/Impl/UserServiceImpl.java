package com.example.learningspringdatajpaproject.services.Impl;

import com.example.learningspringdatajpaproject.entities.Student;
import com.example.learningspringdatajpaproject.entities.Teacher;
import com.example.learningspringdatajpaproject.exceptions.ObjectNotFoundException;
import com.example.learningspringdatajpaproject.exceptions.WrongEmailOrPasswordException;
import com.example.learningspringdatajpaproject.repositories.StudentRepository;
import com.example.learningspringdatajpaproject.repositories.TeacherRepository;
import com.example.learningspringdatajpaproject.repositories.UserRepository;
import com.example.learningspringdatajpaproject.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    @Override
    public Student registerStudent(Student student) { return userRepository.save(student); }

    @Override
    public Teacher registerTeacher(Teacher teacher) { return userRepository.save(teacher); }

    @Override
    public Student logInStudent(String studentEmail, String studentPassword) {
        var student = userRepository.findByEmail(studentEmail).orElseThrow(
                () -> new ObjectNotFoundException("User not found")
        );

        if(!student.getPassword().equals(studentPassword)) throw new WrongEmailOrPasswordException("Wrong credentials!");

        return (Student) student;
    }

    @Override
    public Teacher logInTeacher(String teacherEmail, String teacherPassword) {
        var teacher = userRepository.findByEmail(teacherEmail).orElseThrow(
                () -> new ObjectNotFoundException("User not found")
        );

        if(!teacher.getPassword().equals(teacherPassword)) throw new WrongEmailOrPasswordException("Wrong credentials!");

        return (Teacher) teacher;
    }
}
