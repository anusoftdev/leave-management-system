package com.anusoft.lms.service;

import com.anusoft.lms.dto.LeaveApprovalDto;
import com.anusoft.lms.dto.LeaveRequestCreateDto;
import com.anusoft.lms.dto.LeaveResponseDto;

import java.util.List;

public interface LeaveRequestService {
    LeaveResponseDto applyLeave(LeaveRequestCreateDto dto);
    List<LeaveResponseDto> getLeavesByEmployee(String employeeId);
    List<LeaveResponseDto> getAllLeaves();
    LeaveResponseDto approveLeave(Long leaveId, LeaveApprovalDto dto);
    LeaveResponseDto rejectLeave(Long leaveId, LeaveApprovalDto dto);
}