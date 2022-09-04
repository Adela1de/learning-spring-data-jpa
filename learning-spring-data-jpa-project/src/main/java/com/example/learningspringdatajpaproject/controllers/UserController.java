package com.example.learningspringdatajpaproject.controllers;

import com.example.learningspringdatajpaproject.entities.Student;
import com.example.learningspringdatajpaproject.entities.Teacher;
import com.example.learningspringdatajpaproject.entities.User;
import com.example.learningspringdatajpaproject.requests.UserLogInRequestBody;
import com.example.learningspringdatajpaproject.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {

    private final UserService userService;

    @PostMapping("/register/student")
    public ResponseEntity<Student> registerStudent(@RequestBody Student student)
    {
        return ResponseEntity.ok().body(userService.registerStudent(student));
    }

    @PostMapping("/register/teacher")
    public ResponseEntity<Teacher> registerTeacher(@RequestBody Teacher teacher)
    {
        return ResponseEntity.ok().body(userService.registerTeacher(teacher));
    }

    @PostMapping("/login")
    public ResponseEntity<User> userLogIn(@RequestBody UserLogInRequestBody userLogInRequestBody)
    {
        return ResponseEntity.ok().body(userService.userLogIn(
                userLogInRequestBody.getEmail(),
                userLogInRequestBody.getPassword())
        );
    }

}
