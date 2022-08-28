package com.example.learningspringdatajpaproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_course")
@NoArgsConstructor
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long courseId;
    private String title;
    private Integer credit;
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

    public Course(String title, Integer credit)
    {
        this.title = title;
        this.credit = credit;
    }
}
