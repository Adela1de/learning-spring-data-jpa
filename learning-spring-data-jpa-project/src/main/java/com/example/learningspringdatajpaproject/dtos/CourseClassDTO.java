package com.example.learningspringdatajpaproject.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CourseClassDTO {

    private String title;
    private Integer credit;
    private String teacherName;

}
