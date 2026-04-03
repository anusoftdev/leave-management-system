package com.anusoft.lms.service.impl;

import com.anusoft.lms.dto.LeaveApprovalDto;
import com.anusoft.lms.dto.LeaveRequestCreateDto;
import com.anusoft.lms.dto.LeaveResponseDto;
import com.anusoft.lms.entity.LeaveRequest;
import com.anusoft.lms.entity.LeaveStatus;
import com.anusoft.lms.exception.BadRequestException;
import com.anusoft.lms.exception.ResourceNotFoundException;
import com.anusoft.lms.mapper.LeaveRequestMapper;
import com.anusoft.lms.repository.LeaveRequestRepository;
import com.anusoft.lms.service.LeaveRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LeaveRequestServiceImpl implements LeaveRequestService {

    private final LeaveRequestRepository repository;

    @Override
    public LeaveResponseDto applyLeave(LeaveRequestCreateDto dto) {
        if (dto.getStartDate().isAfter(dto.getEndDate())) {
            throw new BadRequestException("Start date cannot be after end date");
        }

        LeaveRequest leaveRequest = LeaveRequestMapper.toEntity(dto);
        LeaveRequest saved = repository.save(leaveRequest);
        return LeaveRequestMapper.toDto(saved);
    }

    @Override
    public List<LeaveResponseDto> getLeavesByEmployee(String employeeId) {
        return repository.findByEmployeeId(employeeId)
                .stream()
                .map(LeaveRequestMapper::toDto)
                .toList();
    }

    @Override
    public List<LeaveResponseDto> getAllLeaves() {
        return repository.findAll()
                .stream()
                .map(LeaveRequestMapper::toDto)
                .toList();
    }

    @Override
    public LeaveResponseDto approveLeave(Long leaveId, LeaveApprovalDto dto) {
        LeaveRequest leave = repository.findById(leaveId)
                .orElseThrow(() -> new ResourceNotFoundException("Leave request not found"));

        if (leave.getStatus() != LeaveStatus.PENDING) {
            throw new BadRequestException("Only pending leave can be approved");
        }

        leave.setStatus(LeaveStatus.APPROVED);
        leave.setManagerComments(dto.getManagerComments());

        return LeaveRequestMapper.toDto(repository.save(leave));
    }

    @Override
    public LeaveResponseDto rejectLeave(Long leaveId, LeaveApprovalDto dto) {
        LeaveRequest leave = repository.findById(leaveId)
                .orElseThrow(() -> new ResourceNotFoundException("Leave request not found"));

        if (leave.getStatus() != LeaveStatus.PENDING) {
            throw new BadRequestException("Only pending leave can be rejected");
        }

        leave.setStatus(LeaveStatus.REJECTED);
        leave.setManagerComments(dto.getManagerComments());

        return LeaveRequestMapper.toDto(repository.save(leave));
    }
}