package com.example.learningspringdatajpaproject.controllers;

import com.example.learningspringdatajpaproject.dtos.UserStudentDTO;
import com.example.learningspringdatajpaproject.dtos.UserTeacherDTO;
import com.example.learningspringdatajpaproject.entities.Student;
import com.example.learningspringdatajpaproject.entities.Teacher;
import com.example.learningspringdatajpaproject.entities.User;
import com.example.learningspringdatajpaproject.events.RegistrationEvent;
import com.example.learningspringdatajpaproject.exceptions.WrongTypeException;
import com.example.learningspringdatajpaproject.mappers.StudentMapper;
import com.example.learningspringdatajpaproject.mappers.TeacherMapper;
import com.example.learningspringdatajpaproject.requests.UserLogInRequestBody;
import com.example.learningspringdatajpaproject.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {

    private final UserService userService;
    private final StudentMapper studentMapper;
    private final TeacherMapper teacherMapper;
    private final ApplicationEventPublisher applicationEventPublisher;

    @PostMapping("/register/student")
    public ResponseEntity<Student> registerStudent(@RequestBody Student student,
                                                  HttpServletRequest request)
    {
        var user = userService.registerStudent(student);
        applicationEventPublisher.publishEvent(new RegistrationEvent(user, applicationUrl(request)));
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/register/teacher")
    public ResponseEntity<Teacher> registerTeacher(@RequestBody Teacher teacher,
                                                  HttpServletRequest request)
    {

        var user = userService.registerTeacher(teacher);
        applicationEventPublisher.publishEvent(new RegistrationEvent(user, applicationUrl(request)));
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/login/student")
    public ResponseEntity<UserStudentDTO> studentLogIn(@RequestBody UserLogInRequestBody userLogInRequestBody)
    {
        String role = "STUDENT";
        var user = getUser(userLogInRequestBody, role);

        var userStudentDTO = studentMapper.toUserStudentDTO(user);
        return ResponseEntity.ok().body(userStudentDTO);
    }

    @PostMapping("/login/teacher")
    public ResponseEntity<UserTeacherDTO> teacherLogIn(@RequestBody UserLogInRequestBody userLogInRequestBody)
    {
        String role = "TEACHER";
        var user = getUser(userLogInRequestBody, role);

        var userTeacherDTO = teacherMapper.toUserTeacherDTO(user);
        return ResponseEntity.ok().body(userTeacherDTO);
    }

    @GetMapping("/confirmRegistration")
    public ResponseEntity<String> confirmRegistration(@RequestParam("token") String token)
    {
        userService.validateVerificationToken(token);
        return ResponseEntity.ok().body("User registration confirmed!");
    }

    private User getUser(UserLogInRequestBody userLogInRequestBody, String role)
    {
        var user = userService.userLogIn(
                        userLogInRequestBody.getEmail(),
                        userLogInRequestBody.getPassword());

        if(!user.getRole().equalsIgnoreCase(role))
            throw new WrongTypeException("User is not a " + role.toLowerCase()+ " !");
        return user;
    }

    private String applicationUrl(HttpServletRequest request)
    {
        return "http://" +
                request.getServerName() +
                ":" +
                request.getServerPort() +
                request.getContextPath();
    }

}
