package com.anusoft.lms.mapper;

import com.anusoft.lms.dto.LeaveRequestCreateDto;
import com.anusoft.lms.dto.LeaveResponseDto;
import com.anusoft.lms.entity.LeaveRequest;
import com.anusoft.lms.entity.LeaveStatus;

public class LeaveRequestMapper {

    public static LeaveRequest toEntity(LeaveRequestCreateDto dto) {
        return LeaveRequest.builder()
                .employeeId(dto.getEmployeeId())
                .employeeName(dto.getEmployeeName())
                .leaveType(dto.getLeaveType())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .reason(dto.getReason())
                .status(LeaveStatus.PENDING)
                .build();
    }

    public static LeaveResponseDto toDto(LeaveRequest entity) {
        return LeaveResponseDto.builder()
                .id(entity.getId())
                .employeeId(entity.getEmployeeId())
                .employeeName(entity.getEmployeeName())
                .leaveType(entity.getLeaveType())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .reason(entity.getReason())
                .status(entity.getStatus())
                .managerComments(entity.getManagerComments())
                .build();
    }
}