package com.example.learningspringdatajpaproject.repositories;

import com.example.learningspringdatajpaproject.entities.CourseClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseClassRepository  extends JpaRepository<CourseClass, Long> {
}
