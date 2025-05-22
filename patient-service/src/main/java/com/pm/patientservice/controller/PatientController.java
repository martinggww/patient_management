package com.pm.patientservice.controller;

import com.pm.patientservice.service.PatientService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients/") // http://localhost:4000/patients
public class PatientController {
    // Use dependency injection
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }
}
