package com.anusoft.lms.dto;

import com.anusoft.lms.entity.LeaveStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class LeaveResponseDto {
    private Long id;
    private String employeeId;
    private String employeeName;
    private String leaveType;
    private LocalDate startDate;
    private LocalDate endDate;
    private String reason;
    private LeaveStatus status;
    private String managerComments;
}