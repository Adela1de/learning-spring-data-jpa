package com.example.learningspringdatajpaproject.mappers;

import com.example.learningspringdatajpaproject.dtos.CourseClassDTO;
import com.example.learningspringdatajpaproject.dtos.CourseDTO;
import com.example.learningspringdatajpaproject.entities.Course;
import com.example.learningspringdatajpaproject.entities.CourseClass;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CourseClassMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public CourseClassDTO toCourseDTO(CourseClass courseClass)
    {
        var courseClassDTO = new CourseClassDTO();
        courseClassDTO = modelMapper.map(courseClass, CourseClassDTO.class);
        return courseClassDTO;
    }

    public CourseClassDTO toCourseDTOCustomized(CourseClass courseClass)
    {
        var courseClassDTO = new CourseClassDTO();
        courseClassDTO.setTitle(courseClass.getTitle());
        courseClassDTO.setCredit(courseClass.getCredit());
        courseClassDTO.setTeacherName(
                courseClass.getTeacher().getFirstName() +
                " " +
                courseClass.getTeacher().getLastName()
        );
        return courseClassDTO;
    }
}
