package com.anusoft.lms.service;

import com.anusoft.lms.dto.LeaveRequestCreateDto;
import com.anusoft.lms.entity.LeaveRequest;
import com.anusoft.lms.repository.LeaveRequestRepository;
import com.anusoft.lms.service.impl.LeaveRequestServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class LeaveRequestServiceImplTest {

    private LeaveRequestRepository repository;
    private LeaveRequestServiceImpl service;

    @BeforeEach
    void setUp() {
        repository = mock(LeaveRequestRepository.class);
        service = new LeaveRequestServiceImpl(repository);
    }

    @Test
    void shouldApplyLeaveSuccessfully() {
        LeaveRequestCreateDto dto = new LeaveRequestCreateDto();
        dto.setEmployeeId("EMP101");
        dto.setEmployeeName("Anurag");
        dto.setLeaveType("CASUAL");
        dto.setStartDate(LocalDate.now().plusDays(1));
        dto.setEndDate(LocalDate.now().plusDays(2));
        dto.setReason("Personal work");

        LeaveRequest saved = LeaveRequest.builder()
                .id(1L)
                .employeeId(dto.getEmployeeId())
                .employeeName(dto.getEmployeeName())
                .leaveType(dto.getLeaveType())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .reason(dto.getReason())
                .build();

        when(repository.save(any(LeaveRequest.class))).thenReturn(saved);

        var result = service.applyLeave(dto);

        assertEquals("EMP101", result.getEmployeeId());
        verify(repository, times(1)).save(any(LeaveRequest.class));
    }
}