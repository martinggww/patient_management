package com.pm.patientservice.service;

import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.mapper.PatientMapper;
import com.pm.patientservice.model.Patient;
import com.pm.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {
    // All service logics are implemented here
    private PatientRepository patientRepository;
    // This is called dependency ingesting
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientResponseDTO> getPatience() {
        List<Patient> patients = patientRepository.findAll();

        // Inline variables
        return patients.stream()
                .map(PatientMapper::toDTO).toList();
    }
}
