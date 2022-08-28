package com.example.learningspringdatajpaproject.controllers;

import com.example.learningspringdatajpaproject.entities.Course;
import com.example.learningspringdatajpaproject.entities.Guardian;
import com.example.learningspringdatajpaproject.entities.Student;
import com.example.learningspringdatajpaproject.services.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/school")
public class SchoolController {

    private final SchoolService schoolService;

    @GetMapping("/student/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable("studentId") Long studentId)
    {
        return ResponseEntity.ok().body(schoolService.getStudentById(studentId));
    }

    @GetMapping("/guardian/{guardianId}")
    public ResponseEntity<Guardian> getGuardianById(@PathVariable("guardianId") Long guardianId)
    {
        return ResponseEntity.ok().body(schoolService.getGuardianById(guardianId));
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<Course> getCourseById(@PathVariable("courseId") Long courseId)
    {
        return ResponseEntity.ok().body(schoolService.getCourseById(courseId));
    }

    @PostMapping("/student/new")
    public ResponseEntity<Student> addStudent(@RequestBody Student student)
    {
        return ResponseEntity.ok().body(schoolService.saveStudent(student));
    }

    @PostMapping("/guardian/new")
    public ResponseEntity<Guardian> addGuardian(@RequestBody Guardian guardian)
    {
        return ResponseEntity.ok().body(schoolService.saveGuardian(guardian));
    }

    @PostMapping("/course/new")
    public ResponseEntity<Course> addGuardian(@RequestBody Course course)
    {
        return ResponseEntity.ok().body(schoolService.saveCourse(course));
    }

    @PostMapping("/guardian/set/{studentId}/{guardianId}")
    public ResponseEntity<Guardian> setGuardianToStudent(@PathVariable("studentId") Long studentId,
                                                         @PathVariable("guardianId") Long guardianId)
    {
        return ResponseEntity.ok().body(schoolService.assignGuardianToStudent(studentId, guardianId));
    }

    @PostMapping("/course/set/{studentId}/{courseId}")
    public ResponseEntity<Student> setStudentToCourse(@PathVariable("studentId") Long studentId,
                                                      @PathVariable("courseId") Long courseId)
    {
        return ResponseEntity.ok().body(schoolService.assignStudentToACourse(studentId, courseId));
    }
}
