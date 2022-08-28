package com.example.learningspringdatajpaproject.controllers;

import com.example.learningspringdatajpaproject.entities.*;
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

    @GetMapping("/teacher/{teacherId}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable("teacherId") Long teacherId)
    {
        return ResponseEntity.ok().body(schoolService.getTeacherById(teacherId));
    }

    @GetMapping("/courseMaterial/{courseMaterialId}")
    public ResponseEntity<CourseMaterial> getCourseMaterialById(@PathVariable("courseMaterialId") Long courseMaterialId)
    {
        return ResponseEntity.ok().body(schoolService.getCourseMaterialById(courseMaterialId));
    }

    @GetMapping("/courseClass/{courseClassId}")
    public ResponseEntity<CourseClass> getCourseClassById(@PathVariable("courseClassId") Long courseClassId)
    {
        return ResponseEntity.ok().body(schoolService.getCourseClassById(courseClassId));
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

    @PostMapping("/teacher/new")
    public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teacher)
    {
        return ResponseEntity.ok().body(schoolService.saveTeacher(teacher));
    }

    @PostMapping("/courseMaterial/new")
    public ResponseEntity<CourseMaterial> addCourseMaterial(@RequestBody CourseMaterial courseMaterial)
    {
        return ResponseEntity.ok().body(schoolService.saveCourseMaterial(courseMaterial));
    }

    @PostMapping("/courseClass/new")
    public ResponseEntity<CourseClass> addCourseClass(@RequestBody CourseClass courseClass)
    {
        return ResponseEntity.ok().body(schoolService.saveCourseClass(courseClass));
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

    @PostMapping("/course/teacher/set/{teacherId}/{courseId}")
    public ResponseEntity<Course> setTeacherToCourse(@PathVariable("teacherId") Long teacherId,
                                                      @PathVariable("courseId") Long courseId)
    {
        return ResponseEntity.ok().body(schoolService.assignTeacherToCourse(teacherId, courseId));
    }

    @PostMapping("/course/courseMaterial/set/{courseId}/{courseMaterialId}")
    public ResponseEntity<Course> setCourseMaterialToCourse(@PathVariable("courseId") Long courseId,
                                                            @PathVariable("courseMaterialId") Long courseMaterial)
    {
        return ResponseEntity.ok().body(schoolService.assignCourseMaterialToCourse(courseId, courseMaterial));
    }

    @PostMapping("/course/courseClass/set/{courseId}/{courseClassId}")
    public ResponseEntity<CourseClass> setCourseClassToCourse(@PathVariable("courseId") Long courseId,
                                                            @PathVariable("courseClassId") Long courseClassId)
    {
        return ResponseEntity.ok().body(schoolService.assignCourseClassToCourse(courseId, courseClassId));
    }

    @PostMapping("/course/courseClass/student/set/{StudentId}/{courseClassId}")
    public ResponseEntity<CourseClass> setStudentToCourseClass(@PathVariable("StudentId") Long StudentId,
                                                              @PathVariable("courseClassId") Long courseClassId)
    {
        return ResponseEntity.ok().body(schoolService.assignStudentToCourseClass(StudentId, courseClassId));
    }

}
