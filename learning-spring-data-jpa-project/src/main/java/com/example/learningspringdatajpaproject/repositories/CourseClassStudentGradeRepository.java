package com.example.learningspringdatajpaproject.repositories;

import com.example.learningspringdatajpaproject.entities.CourseClassStudentGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseClassStudentGradeRepository extends JpaRepository<CourseClassStudentGrade, Long> {
}
