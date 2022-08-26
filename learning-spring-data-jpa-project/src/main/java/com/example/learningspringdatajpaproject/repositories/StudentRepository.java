package com.example.learningspringdatajpaproject.repositories;

import com.example.learningspringdatajpaproject.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
