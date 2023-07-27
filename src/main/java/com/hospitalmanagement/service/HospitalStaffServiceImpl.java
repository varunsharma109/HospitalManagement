package com.hospitalmanagement.service;


import com.hospitalmanagement.dto.HospitalStaffDto;
import com.hospitalmanagement.exception.HospitalManagementException;
import com.hospitalmanagement.model.HospitalStaff;
import com.hospitalmanagement.repository.HospitalStaffRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HospitalStaffServiceImpl implements HospitalStaffService {

    @Autowired
    private HospitalStaffRepository hospitalStaffRepository;

    @Override
    public HospitalStaffDto signup(HospitalStaffDto hospitalStaffDto) {
        // Check if the username already exists
        if (hospitalStaffRepository.existsByUsername(hospitalStaffDto.getUsername())) {
            throw new HospitalManagementException("Username already exists");
        }
        // Assuming role is set manually while signing up
        HospitalStaff hospitalStaff = new HospitalStaff();
        BeanUtils.copyProperties(hospitalStaffDto, hospitalStaff);
        HospitalStaff savedHospitalStaff = hospitalStaffRepository.save(hospitalStaff);
        BeanUtils.copyProperties(savedHospitalStaff, hospitalStaffDto);
        return hospitalStaffDto;
    }

    @Override
    public HospitalStaffDto login(String username, String password) {
        // Check if the username already exists
        if (!hospitalStaffRepository.existsByUsername(username)) {
            throw new HospitalManagementException("Username Doesn't exist");
        }
        HospitalStaff hospitalStaff = hospitalStaffRepository.findByUsername(username);
        if (hospitalStaff != null && hospitalStaff.getPassword().equals(password)) {
            HospitalStaffDto hospitalStaffDto = new HospitalStaffDto();
            BeanUtils.copyProperties(hospitalStaff, hospitalStaffDto);
            return hospitalStaffDto;
        }
        return null;
    }
}
