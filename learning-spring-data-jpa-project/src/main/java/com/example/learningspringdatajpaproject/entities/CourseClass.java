package com.example.learningspringdatajpaproject.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "tb_course_class")
@NoArgsConstructor
public class CourseClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String title;
    private Integer studentScore;
    private Integer credit;
    @ManyToMany
    @JoinTable(
            name = "tb_course_classes_course",
            joinColumns = @JoinColumn(name = "course_class_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses = new ArrayList<>();
    @ManyToMany
    @JoinTable(
            name = "tb_student_course_classes",
            joinColumns = @JoinColumn(name = "course_class_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students = new ArrayList<>();
    @ManyToMany(mappedBy = "classes")
    private List<CourseClassStudentGrade> courseClassStudentGrades = new ArrayList<>();

    public CourseClass(String title, Integer studentScore, Integer credit) {
        this.title = title;
        this.studentScore = studentScore;
        this.credit = credit;
    }
}
