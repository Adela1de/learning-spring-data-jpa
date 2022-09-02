package com.example.learningspringdatajpaproject.dtos;

import com.example.learningspringdatajpaproject.entities.CourseClass;
import com.example.learningspringdatajpaproject.entities.CourseClassStudentGrade;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class StudentDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String courseTitle;
    private List<CourseClass> courseClasses;
    private List<CourseClassStudentGrade> grades;

}
