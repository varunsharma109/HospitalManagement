package com.hospitalmanagement.service;

import com.hospitalmanagement.dto.PatientDto;

import java.util.List;

public interface PatientService {

    PatientDto admitPatient(PatientDto patientDto);
    List<PatientDto> getAdmittedPatients();
    void dischargePatient(Long patientId);
}
