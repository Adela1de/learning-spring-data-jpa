package com.example.learningspringdatajpaproject.mappers;

import com.example.learningspringdatajpaproject.dtos.UserTeacherDTO;
import com.example.learningspringdatajpaproject.entities.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TeacherMapper {

    private static final ModelMapper modelMapper = new ModelMapper();


    public UserTeacherDTO toUserTeacherDTO(User user)
    {
        var userTeacherDTO = new UserTeacherDTO();
        userTeacherDTO = modelMapper.map(user, UserTeacherDTO.class);
        return userTeacherDTO;
    }

}
