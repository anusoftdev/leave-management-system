package com.anusoft.lms.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class LeaveRequestCreateDto {

    @NotBlank
    private String employeeId;

    @NotBlank
    private String employeeName;

    @NotBlank
    private String leaveType;

    @NotNull
    @FutureOrPresent
    private LocalDate startDate;

    @NotNull
    @FutureOrPresent
    private LocalDate endDate;

    private String reason;
}