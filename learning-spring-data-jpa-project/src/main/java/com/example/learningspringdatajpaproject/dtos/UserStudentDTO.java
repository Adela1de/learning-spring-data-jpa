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
public class UserStudentDTO{

    private Long userId;
    private String firstName;
    private String lastName;
    private String courseTitle;
    private List<CourseClass> courseClasses;
    private List<CourseClassStudentGrade> grades;
    private String role;

}
