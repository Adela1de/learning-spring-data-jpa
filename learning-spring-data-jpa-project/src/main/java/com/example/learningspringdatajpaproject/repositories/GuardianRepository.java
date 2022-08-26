package com.example.learningspringdatajpaproject.repositories;

import com.example.learningspringdatajpaproject.entities.Guardian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuardianRepository extends JpaRepository<Guardian, Long> {
}
