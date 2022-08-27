package com.example.learningspringdatajpaproject.controllers;

import com.example.learningspringdatajpaproject.entities.Guardian;
import com.example.learningspringdatajpaproject.entities.Student;
import com.example.learningspringdatajpaproject.services.GuardianService;
import com.example.learningspringdatajpaproject.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/school")
public class SchoolController {

    private final StudentService studentService;
    private final GuardianService guardianService;


    @PostMapping("/student/new")
    public ResponseEntity<Student> addStudent(@RequestBody Student student)
    {
        return ResponseEntity.ok().body(studentService.saveStudent(student));
    }

    @PostMapping("/guardian/new")
    public ResponseEntity<Guardian> addGuardian(@RequestBody Guardian guardian)
    {
        return ResponseEntity.ok().body(guardianService.saveGuardian(guardian));
    }

    @PostMapping("/guardian/set/{studentId}/{guardianId}")
    public ResponseEntity<Guardian> setGuardianToStudent(@PathVariable("studentId") Long studentId,
                                                         @PathVariable("guardianId") Long guardianId)
    {
        return ResponseEntity.ok().body(studentService.setGuardianToStudent(studentId, guardianId));
    }
}
