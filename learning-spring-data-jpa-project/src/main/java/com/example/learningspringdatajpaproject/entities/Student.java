package com.example.learningspringdatajpaproject.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tb_student")
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    private String firstName;
    private String lastName;
    @Column(name = "email_address")
    private String email;
    @OneToOne(mappedBy = "student")
    private Guardian guardian;

}
