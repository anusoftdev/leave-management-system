package com.anusoft.lms.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LeaveApprovalDto {

    @NotBlank
    private String managerComments;
}