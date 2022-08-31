package com.example.learningspringdatajpaproject.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
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
    private String password;
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
    @ManyToMany(mappedBy = "studentsGrade")
    private List<CourseClassStudentGrade> courseClassStudentGrades  = new ArrayList<>();

    public Student(String firstName, String lastName, String email, String password)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

}
