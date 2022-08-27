package com.example.learningspringdatajpaproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "tb_guardian")
@NoArgsConstructor
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
    @JsonIgnore
    private Student student;

    public Guardian(String name, String email, String mobile)
    {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }
}
