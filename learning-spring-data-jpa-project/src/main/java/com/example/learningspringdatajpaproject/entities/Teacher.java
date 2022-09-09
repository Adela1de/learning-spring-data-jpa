package com.example.learningspringdatajpaproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "tb_teacher")
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Teacher extends User {

    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "teacher")
    @JsonIgnore
    private List<CourseClass> courseClasses;

    public Teacher(String firstName, String lastName, String email, String password) {
        super(email, password, "TEACHER");
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
