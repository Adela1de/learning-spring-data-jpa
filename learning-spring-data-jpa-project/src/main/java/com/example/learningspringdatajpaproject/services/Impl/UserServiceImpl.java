package com.example.learningspringdatajpaproject.services.Impl;

import com.example.learningspringdatajpaproject.entities.Student;
import com.example.learningspringdatajpaproject.entities.Teacher;
import com.example.learningspringdatajpaproject.entities.User;
import com.example.learningspringdatajpaproject.exceptions.ObjectNotFoundException;
import com.example.learningspringdatajpaproject.exceptions.WrongEmailOrPasswordException;
import com.example.learningspringdatajpaproject.repositories.UserRepository;
import com.example.learningspringdatajpaproject.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Student registerStudent(Student student) { return userRepository.save(student); }

    @Override
    public Teacher registerTeacher(Teacher teacher) { return userRepository.save(teacher); }

    @Override
    public User getUserByEmailAndPassword(String userEmail, String studentPassword) {
        var user = userRepository.findByEmail(userEmail).orElseThrow(
                () -> new ObjectNotFoundException("User not found")
        );

        if(!user.getPassword().equals(studentPassword)) throw new WrongEmailOrPasswordException("Wrong credentials!");

        return user;
    }
}
