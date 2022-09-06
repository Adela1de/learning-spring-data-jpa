package com.example.learningspringdatajpaproject.mappers;

import com.example.learningspringdatajpaproject.dtos.CourseDTO;
import com.example.learningspringdatajpaproject.entities.Course;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CourseMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public CourseDTO toCourseDTO(Course course)
    {
        var courseDTO = new CourseDTO();
        courseDTO = modelMapper.map(course, CourseDTO.class);
        return courseDTO;
    }

    public CourseDTO toCourseDTOCustomized(Course course)
    {
        var courseDTO = new CourseDTO();
        courseDTO.setCourseId(course.getCourseId());
        courseDTO.setTitle(course.getTitle());
        return courseDTO;
    }
}
