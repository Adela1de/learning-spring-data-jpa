package com.example.learningspringdatajpaproject.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CourseDTO {

    private Long courseId;
    private String title;
    private String teacherName;

}
