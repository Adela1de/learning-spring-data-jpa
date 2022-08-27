package com.example.learningspringdatajpaproject.controllers;

import com.example.learningspringdatajpaproject.entities.Guardian;
import com.example.learningspringdatajpaproject.entities.Student;
import com.example.learningspringdatajpaproject.services.GuardianService;
import com.example.learningspringdatajpaproject.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/school")
public class SchoolController {

    private final StudentService studentService;
    private final GuardianService guardianService;


    @GetMapping("/student/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable("studentId") Long studentId)
    {
        return ResponseEntity.ok().body(studentService.getStudentById(studentId));
    }

    @GetMapping("/guardian/{guardianId}")
    public ResponseEntity<Guardian> getGuardianById(@PathVariable("guardianId") Long guardianId)
    {
        return ResponseEntity.ok().body(studentService.getGuardianById(guardianId));
    }

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
