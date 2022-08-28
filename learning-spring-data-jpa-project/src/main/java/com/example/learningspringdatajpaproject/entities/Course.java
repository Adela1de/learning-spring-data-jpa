package com.example.learningspringdatajpaproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "tb_course")
@NoArgsConstructor
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long courseId;
    private String title;
    @JsonIgnore
    @OneToMany(mappedBy = "course")
    private List<Student> students = new ArrayList<>();
    @OneToOne
    @JoinColumn(
            name = "teacher_id",
            foreignKey = @ForeignKey(name = "course_teacher_id")
    )
    private Teacher teacher;
    @OneToOne
    @JoinColumn(
            name = "course_material_id",
            foreignKey = @ForeignKey(name = "course_course_material_id")
    )
    private CourseMaterial material;
    @ManyToMany(mappedBy = "courses")
    @JsonIgnore
    private List<CourseClass> classes = new ArrayList<>();

    public Course(String title)
    {
        this.title = title;
    }
}
