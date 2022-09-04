package com.example.learningspringdatajpaproject.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "tb_student")
@DiscriminatorValue("studentId")
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Student extends User implements Serializable {

    private String firstName;
    private String lastName;
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
        super(email, password);
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
