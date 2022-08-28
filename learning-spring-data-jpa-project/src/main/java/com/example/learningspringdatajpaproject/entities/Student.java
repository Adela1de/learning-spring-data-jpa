package com.example.learningspringdatajpaproject.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_student")
@NoArgsConstructor
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long studentId;
    private String firstName;
    private String lastName;
    @Column(name = "email_address")
    private String email;
    @OneToOne(mappedBy = "student")
    private Guardian guardian;
    @ManyToOne
    @JoinColumn(
            name = "course_id",
            foreignKey = @ForeignKey(name = "student_course_id")
    )
    private Course course;
    @ManyToMany(mappedBy = "students")
    private List<CourseClass> classes = new ArrayList<>();

    public Student(String firstName, String lastName, String email)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

}
