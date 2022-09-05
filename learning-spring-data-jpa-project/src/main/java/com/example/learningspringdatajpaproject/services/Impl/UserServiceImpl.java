package com.example.learningspringdatajpaproject.services.Impl;

import com.example.learningspringdatajpaproject.entities.Student;
import com.example.learningspringdatajpaproject.entities.Teacher;
import com.example.learningspringdatajpaproject.entities.User;
import com.example.learningspringdatajpaproject.entities.VerificationToken;
import com.example.learningspringdatajpaproject.exceptions.ObjectNotFoundException;
import com.example.learningspringdatajpaproject.exceptions.WrongEmailOrPasswordException;
import com.example.learningspringdatajpaproject.repositories.UserRepository;
import com.example.learningspringdatajpaproject.repositories.VerificationTokenRepository;
import com.example.learningspringdatajpaproject.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final VerificationTokenRepository verificationTokenRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Student registerStudent(Student student)
    {
        student.setRole("STUDENT");
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        return userRepository.save(student);
    }

    @Override
    public Teacher registerTeacher(Teacher teacher)
    {
        teacher.setRole("TEACHER");
        teacher.setPassword(passwordEncoder.encode(teacher.getPassword()));
        return userRepository.save(teacher);
    }

    @Override
    public User userLogIn(String userEmail, String userPassword) {
        var user = userRepository.findByEmail(userEmail).orElseThrow(
                () -> new ObjectNotFoundException("User not found! ")
        );

        if(!user.getPassword().equals(passwordEncoder.encode(userPassword)))
            throw new WrongEmailOrPasswordException("Wrong credentials!");

        return user;
    }

    @Override
    public VerificationToken saveVerificationTokenForUser(User user, String token) {
        var verificationToken = new VerificationToken(user, token);
        return verificationTokenRepository.save(verificationToken);
    }


}
