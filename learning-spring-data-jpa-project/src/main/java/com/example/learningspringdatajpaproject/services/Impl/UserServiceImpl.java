package com.example.learningspringdatajpaproject.services.Impl;

import com.example.learningspringdatajpaproject.entities.Student;
import com.example.learningspringdatajpaproject.entities.Teacher;
import com.example.learningspringdatajpaproject.entities.User;
import com.example.learningspringdatajpaproject.entities.VerificationToken;
import com.example.learningspringdatajpaproject.exceptions.InvalidTokenException;
import com.example.learningspringdatajpaproject.exceptions.ObjectNotFoundException;
import com.example.learningspringdatajpaproject.exceptions.WrongEmailOrPasswordException;
import com.example.learningspringdatajpaproject.repositories.UserRepository;
import com.example.learningspringdatajpaproject.repositories.VerificationTokenRepository;
import com.example.learningspringdatajpaproject.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;

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

        if(!passwordEncoder.matches(userPassword, user.getPassword()))
            throw new WrongEmailOrPasswordException("Wrong credentials!");

        return user;
    }

    @Override
    public VerificationToken saveVerificationTokenForUser(User user, String token) {
        var verificationToken = new VerificationToken(user, token);
        return verificationTokenRepository.save(verificationToken);
    }

    @Override
    public VerificationToken findVerificationTokenByToken(String token) {
        return findVerificationTokenByTokenOrElseThrowException(token);
    }

    @Override
    public void validateVerificationToken(String token)
    {
        var verificationToken = findVerificationTokenByToken(token);

        var cal = Calendar.getInstance();
        if(verificationToken.getExpirationTime().getTime() - cal.getTime().getTime() <= 10)
            throw new InvalidTokenException("token expired! ");

        var user = verificationToken.getUser();
        user.setEnabled(true);
        userRepository.save(user);
    }

    private VerificationToken findVerificationTokenByTokenOrElseThrowException(String token)
    {
        return verificationTokenRepository.findByToken(token).orElseThrow(
                () -> new ObjectNotFoundException("Token not found!")
        );
    }


}
