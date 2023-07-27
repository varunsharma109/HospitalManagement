package com.hospitalmanagement.service;

import com.hospitalmanagement.dto.HospitalStaffDto;
import com.hospitalmanagement.model.HospitalStaff;


public interface HospitalStaffService {

        HospitalStaffDto signup(HospitalStaffDto hospitalStaffDto);
        HospitalStaffDto login(String username, String password);

}
