package com.example.learningspringdatajpaproject.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tb_course_material")
@NoArgsConstructor
public class CourseMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long courseMaterialId;
    private String url;
    @OneToOne(mappedBy = "courseMaterialUrl")
    private Course course;

    public CourseMaterial(String url) {
        this.url = url;
    }
}
