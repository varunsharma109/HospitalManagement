package com.hospitalmanagement.dto;


import javax.persistence.*;

public class HospitalStaffDto {

    private String username;

    private String password;
    private String role; // Assuming roles: "DOCTOR" or "NURSE"

    // Getters and Setters, Constructors

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
