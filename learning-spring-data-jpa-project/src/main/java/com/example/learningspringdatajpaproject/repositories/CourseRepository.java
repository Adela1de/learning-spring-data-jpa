package com.example.learningspringdatajpaproject.repositories;

import com.example.learningspringdatajpaproject.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
