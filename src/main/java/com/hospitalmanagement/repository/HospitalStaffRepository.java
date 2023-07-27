package com.hospitalmanagement.repository;

import com.hospitalmanagement.dto.HospitalStaffDto;
import com.hospitalmanagement.model.HospitalStaff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalStaffRepository extends JpaRepository<HospitalStaff, Long> {

    HospitalStaff findByUsername(String username);
    boolean existsByUsername(String username);
}
