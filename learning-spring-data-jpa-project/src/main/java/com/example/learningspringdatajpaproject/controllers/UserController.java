package com.example.learningspringdatajpaproject.controllers;

import com.example.learningspringdatajpaproject.dtos.UserStudentDTO;
import com.example.learningspringdatajpaproject.dtos.UserTeacherDTO;
import com.example.learningspringdatajpaproject.entities.Student;
import com.example.learningspringdatajpaproject.entities.Teacher;
import com.example.learningspringdatajpaproject.entities.User;
import com.example.learningspringdatajpaproject.exceptions.WrongTypeException;
import com.example.learningspringdatajpaproject.mappers.StudentMapper;
import com.example.learningspringdatajpaproject.mappers.TeacherMapper;
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
    private final StudentMapper studentMapper;
    private final TeacherMapper teacherMapper;

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

    @PostMapping("/login/student")
    public ResponseEntity<UserStudentDTO> studentLogIn(@RequestBody UserLogInRequestBody userLogInRequestBody)
    {
        var user = getUser(userLogInRequestBody);

        if(!user.getRole().equalsIgnoreCase("STUDENT"))
            throw new WrongTypeException("User is not a student!");

        var userStudentDTO = studentMapper.toUserStudentDTO(user);
        return ResponseEntity.ok().body(userStudentDTO);
    }

    @PostMapping("/login/teacher")
    public ResponseEntity<UserTeacherDTO> teacherLogIn(@RequestBody UserLogInRequestBody userLogInRequestBody)
    {
        var user = getUser(userLogInRequestBody);

        if(!user.getRole().equalsIgnoreCase("TEACHER"))
            throw new WrongTypeException("User is not a teacher!");

        var userTeacherDTO = teacherMapper.toUserTeacherDTO(user);
        return ResponseEntity.ok().body(userTeacherDTO);
    }

    private User getUser(UserLogInRequestBody userLogInRequestBody)
    {
        return userService.userLogIn(
            userLogInRequestBody.getEmail(),
            userLogInRequestBody.getPassword());
    }

}
