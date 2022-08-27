package com.example.learningspringdatajpaproject.services.Impl;

import com.example.learningspringdatajpaproject.entities.Guardian;
import com.example.learningspringdatajpaproject.repositories.GuardianRepository;
import com.example.learningspringdatajpaproject.services.GuardianService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GuardianServiceImpl implements GuardianService {

    private final GuardianRepository guardianRepository;

    @Override
    public Guardian saveGuardian(Guardian guardian) {
        return guardianRepository.save(guardian);
    }
}
