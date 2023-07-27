package com.hospitalmanagement.service;

import com.hospitalmanagement.dto.PatientDto;
import com.hospitalmanagement.exception.HospitalManagementException;
import com.hospitalmanagement.model.Patient;
import com.hospitalmanagement.repository.PatientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public PatientDto admitPatient(PatientDto patientDto) {
        // Validate status to be "admitted"
        if (!"admitted".equalsIgnoreCase(patientDto.getStatus())) {
            throw new HospitalManagementException("Invalid status. Patient must be 'admitted'");
        }

        Patient patient = new Patient();
        BeanUtils.copyProperties(patientDto,patient);
        Patient savedPatient = patientRepository.save(patient);
        BeanUtils.copyProperties(savedPatient,patientDto);
        return patientDto;
    }

    @Override
    public List<PatientDto> getAdmittedPatients() {
        List<Patient> admittedPatients = patientRepository.findByStatus("admitted");
        return admittedPatients.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public void dischargePatient(Long patientId) {
        // Check if patient exists
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new HospitalManagementException("Patient not found"));

        // Validate status to be "admitted"
        if (!"admitted".equalsIgnoreCase(patient.getStatus())) {
            throw new HospitalManagementException("Patient is already discharged");
        }

        // Update status to "discharged"
        patient.setStatus("discharged");
        patientRepository.save(patient);
    }

    private PatientDto convertToDto(Patient patient) {
        PatientDto patientDto = new PatientDto();
        patientDto.setId(patient.getId());
        patientDto.setName(patient.getName());
        patientDto.setAge(patient.getAge());
        patientDto.setRoom(patient.getRoom());
        patientDto.setDoctorName(patient.getDoctorName());
        patientDto.setAdmitDate(patient.getAdmitDate());
        patientDto.setExpenses(patient.getExpenses());
        patientDto.setStatus(patient.getStatus());
        return patientDto;
    }
}
