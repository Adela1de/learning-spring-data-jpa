package com.example.learningspringdatajpaproject.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "tb_course_class_student_grade")
@NoArgsConstructor
public class CourseClassStudentGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private Double studentGrade;
    @ManyToMany
    @JoinTable(
            name = "tb_course_class_grade",
            joinColumns = @JoinColumn(name = "course_class_student_grade_id"),
            inverseJoinColumns = @JoinColumn(name = "course_class_id")
    )
    private List<CourseClass> classes = new ArrayList<>();
    @ManyToMany
    @JoinTable(
            name = "tb_student_grade",
            joinColumns = @JoinColumn(name = "course_class_student_grade_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> studentsGrade = new ArrayList<>();

    public CourseClassStudentGrade(Double studentGrade) {
        this.studentGrade = studentGrade;
    }
}
