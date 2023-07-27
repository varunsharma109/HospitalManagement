package com.hospitalmanagement.controller;

import com.hospitalmanagement.dto.HospitalStaffDto;
import com.hospitalmanagement.service.HospitalStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hospital/staff")
public class HospitalStaffController {

    @Autowired
    private HospitalStaffService hospitalStaffService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody HospitalStaffDto hospitalStaffDto) {
        try{
            HospitalStaffDto savedStaff = hospitalStaffService.signup(hospitalStaffDto);
            return ResponseEntity.ok("Signup successful!");
        }
        catch(Exception e){
            return ResponseEntity.ok(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody HospitalStaffDto loginDto) {
        try{
            HospitalStaffDto hospitalStaff = hospitalStaffService.login(loginDto.getUsername(), loginDto.getPassword());
            if (hospitalStaff != null) {
                return ResponseEntity.ok("Login successful!");
            }
            else {
                return ResponseEntity.ok("Login Unsuccessful!");
            }
        }
        catch(Exception e){
            return ResponseEntity.ok(e.getMessage());
        }

    }
}
