package com.anusoft.lms.controller;

import com.anusoft.lms.dto.LeaveApprovalDto;
import com.anusoft.lms.dto.LeaveRequestCreateDto;
import com.anusoft.lms.dto.LeaveResponseDto;
import com.anusoft.lms.service.LeaveRequestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaves")
@RequiredArgsConstructor
public class LeaveRequestController {

    private final LeaveRequestService leaveRequestService;

    @PostMapping("/apply")
    public LeaveResponseDto applyLeave(@Valid @RequestBody LeaveRequestCreateDto dto) {
        return leaveRequestService.applyLeave(dto);
    }

    @GetMapping("/employee/{employeeId}")
        public List<LeaveResponseDto> getLeavesByEmployee(@PathVariable String employeeId) {
        return leaveRequestService.getLeavesByEmployee(employeeId);
    }

    @GetMapping
    public List<LeaveResponseDto> getAllLeaves() {
        return leaveRequestService.getAllLeaves();
    }

    @PutMapping("/{leaveId}/approve")
    public LeaveResponseDto approveLeave(@PathVariable Long leaveId,
                                         @Valid @RequestBody LeaveApprovalDto dto) {
        return leaveRequestService.approveLeave(leaveId, dto);
    }

    @PutMapping("/{leaveId}/reject")
    public LeaveResponseDto rejectLeave(@PathVariable Long leaveId,
                                        @Valid @RequestBody LeaveApprovalDto dto) {
        return leaveRequestService.rejectLeave(leaveId, dto);
    }
}