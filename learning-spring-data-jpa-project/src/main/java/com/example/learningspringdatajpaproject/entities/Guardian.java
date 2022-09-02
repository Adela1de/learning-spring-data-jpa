package com.example.learningspringdatajpaproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tb_guardian")
@NoArgsConstructor
public class Guardian implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long guardianId;
    private String name;
    private String email;
    private String mobile;
    @OneToOne
    @JoinColumn(
            name = "student_id",
            foreignKey = @ForeignKey(name = "guardian_student_id")
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
