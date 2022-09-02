package com.example.learningspringdatajpaproject.mappers;

import com.example.learningspringdatajpaproject.dtos.StudentDTO;
import com.example.learningspringdatajpaproject.entities.Student;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class StudentMapper {

    private static final ModelMapper modelMapper = new ModelMapper();


    public StudentDTO toCourseDTO(Student student)
    {
        var studentDTO = new StudentDTO();
        studentDTO = modelMapper.map(student, StudentDTO.class);
        return studentDTO;
    }

    public StudentDTO toCourseDTOCustomized(Student student)
    {
        var studentDTO = new StudentDTO();
        studentDTO.setFirstName(student.getFirstName());
        studentDTO.setLastName(student.getLastName());
        studentDTO.setEmail(student.getEmail());
        studentDTO.setPassword(student.getPassword());
        if(student.getCourse() != null) studentDTO.setCourseTitle(student.getCourse().getTitle());
        if(student.getClasses() != null) studentDTO.setCourseClasses(student.getClasses());
        if(student.getCourseClassStudentGrades() != null) studentDTO.setGrades(student.getCourseClassStudentGrades());

        return studentDTO;
    }
}
