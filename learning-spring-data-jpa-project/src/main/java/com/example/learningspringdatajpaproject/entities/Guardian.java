package com.example.learningspringdatajpaproject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tb_guardian")
@NoArgsConstructor
@AllArgsConstructor
public class Guardian implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String mobile;
    @OneToOne
    @JoinColumn(
            name = "student_id",
            foreignKey = @ForeignKey(name = "student_student_id")
    )
    private Student student;
}
