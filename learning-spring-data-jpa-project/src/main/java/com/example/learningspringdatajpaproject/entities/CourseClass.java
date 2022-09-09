package com.example.learningspringdatajpaproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Long courseClassId;
    private String title;
    private Integer credit;
    @ManyToMany
    @JoinTable(
            name = "tb_course_classes_course",
            joinColumns = @JoinColumn(name = "course_class_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    @JsonIgnore
    private List<Course> courses = new ArrayList<>();
    @ManyToMany
    @JoinTable(
            name = "tb_student_course_classes",
            joinColumns = @JoinColumn(name = "course_class_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    @JsonIgnore
    private List<Student> students = new ArrayList<>();
    @ManyToMany(mappedBy = "classes")
    @JsonIgnore
    private List<CourseClassStudentGrade> courseClassStudentGrades = new ArrayList<>();
    @ManyToOne
    @JoinColumn(
            name = "teacher_id",
            foreignKey = @ForeignKey(name = "course_class_teacher_id")
    )
    private Teacher teacher;

    public CourseClass(String title, Integer credit) {
        this.title = title;
        this.credit = credit;
    }
}
