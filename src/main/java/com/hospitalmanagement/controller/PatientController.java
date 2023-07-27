package com.hospitalmanagement.controller;

import com.hospitalmanagement.dto.PatientDto;
import com.hospitalmanagement.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/hospital/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/admit")
    public ResponseEntity<Object> admitPatient(@RequestBody @Valid PatientDto patientDto) {
        try{
            PatientDto admittedPatient = patientService.admitPatient(patientDto);
            return ResponseEntity.ok(admittedPatient);
        }
        catch (Exception e){
            return ResponseEntity.ok(e.getMessage());
        }
    }

    @GetMapping("/admitted")
    public ResponseEntity<List<PatientDto>> getAdmittedPatients() {
        List<PatientDto> admittedPatients = patientService.getAdmittedPatients();
        return ResponseEntity.ok(admittedPatients);
    }

    @PutMapping("/discharge/{patientId}")
    public ResponseEntity<String> dischargePatient(@PathVariable Long patientId) {
        try{
            patientService.dischargePatient(patientId);
            return ResponseEntity.ok("Patient discharged successfully!");
        }
        catch (Exception e){
            return ResponseEntity.ok(e.getMessage());
        }
    }
}
