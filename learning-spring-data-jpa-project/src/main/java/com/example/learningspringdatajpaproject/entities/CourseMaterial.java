package com.example.learningspringdatajpaproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_course_material")
@NoArgsConstructor
public class CourseMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long courseMaterialId;
    private String url;
    @OneToOne(mappedBy = "material")
    @JsonIgnore
    private Course course;

    public CourseMaterial(String url) {
        this.url = url;
    }
}
