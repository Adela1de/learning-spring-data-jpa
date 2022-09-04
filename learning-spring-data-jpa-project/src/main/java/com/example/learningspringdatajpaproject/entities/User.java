package com.example.learningspringdatajpaproject.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tb_user")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("userId")
@NoArgsConstructor
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long userId;
    @Column(name = "email_address")
    private String email;
    private String password;
    private boolean enabled = false;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
