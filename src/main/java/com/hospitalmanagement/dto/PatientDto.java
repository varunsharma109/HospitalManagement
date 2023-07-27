package com.hospitalmanagement.dto;

import javax.validation.constraints.NotNull;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class PatientDto {

    private Long id;
    @NotBlank(message = "Name is required")
    private String name;
    @Min(value = 0, message = "Age must be a positive number")
    private int age;
    @NotBlank(message = "Room is required")
    private String room;
    @NotBlank(message = "Doctor name is required")
    private String doctorName;
    @NotNull
    private LocalDate admitDate;
    @Min(value = 0, message = "Expenses must be a positive number")
    private double expenses;
    @NotBlank(message = "Status is required")
    private String status; // Assuming status: "admitted" or "discharged"

    // Getters and Setters, Constructors


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public LocalDate getAdmitDate() {
        return admitDate;
    }

    public void setAdmitDate(LocalDate admitDate) {
        this.admitDate = admitDate;
    }

    public double getExpenses() {
        return expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
