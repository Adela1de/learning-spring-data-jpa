package com.example.learningspringdatajpaproject.services.Impl;

import com.example.learningspringdatajpaproject.entities.Student;
import com.example.learningspringdatajpaproject.entities.Teacher;
import com.example.learningspringdatajpaproject.entities.User;
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
    public Student registerStudent(Student student)
    {
        student.setRole("STUDENT");
        return userRepository.save(student);
    }

    @Override
    public Teacher registerTeacher(Teacher teacher)
    {
        teacher.setRole("TEACHER");
        return userRepository.save(teacher);
    }

    @Override
    public <T extends User> T userLogIn(String userEmail, String userPassword) {
        var user = userRepository.findByEmail(userEmail).orElseThrow(
                () -> new ObjectNotFoundException("User not found! ")
        );

        if(!user.getPassword().equals(userPassword)) throw new WrongEmailOrPasswordException("Wrong credentials!");

        return (T) user;
    }



}
