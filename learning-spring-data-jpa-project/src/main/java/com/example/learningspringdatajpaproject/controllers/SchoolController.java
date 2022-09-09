package com.example.learningspringdatajpaproject.controllers;

import com.example.learningspringdatajpaproject.dtos.CourseClassDTO;
import com.example.learningspringdatajpaproject.dtos.CourseDTO;
import com.example.learningspringdatajpaproject.dtos.StudentDTO;
import com.example.learningspringdatajpaproject.entities.*;
import com.example.learningspringdatajpaproject.mappers.CourseClassMapper;
import com.example.learningspringdatajpaproject.mappers.CourseMapper;
import com.example.learningspringdatajpaproject.mappers.StudentMapper;
import com.example.learningspringdatajpaproject.services.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/school")
@CrossOrigin("*")
public class SchoolController {

    private final SchoolService schoolService;
    private final CourseMapper courseMapper;
    private final StudentMapper studentMapper;
    private final CourseClassMapper courseClassMapper;

    @GetMapping("/student/{studentId}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable("studentId") Long studentId)
    {
        var student = schoolService.getStudentById(studentId);
        var studentDTO = studentMapper.toCourseDTOCustomized(student);
        return ResponseEntity.ok().body(studentDTO);
    }

    @GetMapping("/guardian/{guardianId}")
    public ResponseEntity<Guardian> getGuardianById(@PathVariable("guardianId") Long guardianId)
    {
        return ResponseEntity.ok().body(schoolService.getGuardianById(guardianId));
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable("courseId") Long courseId)
    {
        var course = schoolService.getCourseById(courseId);
        var courseDTO = courseMapper.toCourseDTOCustomized(course);
        return ResponseEntity.ok().body(courseDTO);
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

    @GetMapping("/courses")
    public ResponseEntity<List<CourseDTO>> getAllCourses()
    {
        var courses = schoolService.getAllCourses();
        var coursesDTO = courses.stream().map
                (courseMapper::toCourseDTOCustomized).collect(Collectors.toList()
        );
        return ResponseEntity.ok().body(coursesDTO);
    }

    @GetMapping("/courseClass/student")
    public ResponseEntity<List<CourseClassDTO>> getAllCourseClassesOfAStudent(@RequestParam("studentId") Long studentId)
    {
        var courseClasses = schoolService.getAllCourseClassesOfAStudent(studentId);
        var courseClassesDTO =
                courseClasses.
                stream().
                map(courseClassMapper::toCourseDTOCustomized).
                collect(Collectors.toList());
        return ResponseEntity.ok().body(courseClassesDTO);
    }

    @PostMapping("/guardian/new")
    public ResponseEntity<Guardian> addGuardian(@RequestBody Guardian guardian)
    {
        return ResponseEntity.ok().body(schoolService.saveGuardian(guardian));
    }

    @PostMapping("/course/new")
    public ResponseEntity<Course> addCourse(@RequestBody Course course)
    {
        return ResponseEntity.ok().body(schoolService.saveCourse(course));
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

    @PostMapping("/course/student/set/{studentId}/{courseId}")
    public ResponseEntity<Student> setStudentToCourse(@PathVariable("studentId") Long studentId,
                                                      @PathVariable("courseId") Long courseId)
    {
        return ResponseEntity.ok().body(schoolService.assignStudentToACourse(studentId, courseId));
    }

    @PostMapping("/courseClass/teacher/set/{teacherId}/{courseId}")
    public ResponseEntity<CourseClass> setTeacherToCourseClass(@PathVariable("teacherId") Long teacherId,
                                                         @PathVariable("courseId") Long courseClassId)
    {
        return ResponseEntity.ok().body(schoolService.assignTeacherToCourseClass(teacherId, courseClassId));
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

    @PostMapping("/course/courseClass/student/set/{studentId}/{courseClassId}")
    public ResponseEntity<CourseClass> setStudentToCourseClass(@PathVariable("studentId") Long StudentId,
                                                              @PathVariable("courseClassId") Long courseClassId)
    {
        return ResponseEntity.ok().body(schoolService.assignStudentToCourseClass(StudentId, courseClassId));
    }

    @PostMapping("/course/courseClass/student/grade/set/{studentId}/{courseClassId}")
    public ResponseEntity<Student> setStudentToCourseClass(@PathVariable("studentId") Long StudentId,
                                                           @PathVariable("courseClassId") Long courseClassId,
                                                           @RequestBody CourseClassStudentGrade grade)
    {
        return ResponseEntity.ok().body(schoolService.assignGradeToClass(StudentId, courseClassId, grade));
    }

    @GetMapping("/course")
    public ResponseEntity<List<CourseClassDTO>> returnCourseClassesByCourseName(
            @RequestParam("courseName") String courseName)
    {
        var courseClasses = schoolService.getAllCourseClassesInACourseByTitle(courseName);
        var courseClassesDTO =
                courseClasses.
                stream().
                map(courseClassMapper::toCourseDTOCustomized).
                collect(Collectors.toList());
        return ResponseEntity.ok().body(courseClassesDTO);
    }

}
