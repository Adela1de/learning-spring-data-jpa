package com.example.learningspringdatajpaproject.mappers;

import com.example.learningspringdatajpaproject.dtos.StudentDTO;
import com.example.learningspringdatajpaproject.dtos.UserStudentDTO;
import com.example.learningspringdatajpaproject.entities.Student;
import com.example.learningspringdatajpaproject.entities.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class StudentMapper {

    private static final ModelMapper modelMapper = new ModelMapper();


    public StudentDTO toStudentDTO(Student student)
    {
        var studentDTO = new StudentDTO();
        studentDTO = modelMapper.map(student, StudentDTO.class);
        return studentDTO;
    }

    public UserStudentDTO toUserStudentDTO(User user)
    {
        var userStudentDTO = new UserStudentDTO();
        userStudentDTO = modelMapper.map(user, UserStudentDTO.class);
        return userStudentDTO;
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
