package com.example.learningspringdatajpaproject.repositories;

import com.example.learningspringdatajpaproject.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    Optional<Course> findByTitle(String courseTitle);
}
