package com.example.learningspringdatajpaproject.services.Impl;

import com.example.learningspringdatajpaproject.repositories.GuardianRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GuardianServiceImpl {

    private final GuardianRepository guardianRepository;
}
