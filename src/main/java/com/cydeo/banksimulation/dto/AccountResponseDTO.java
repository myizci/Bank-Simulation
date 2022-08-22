package com.cydeo.banksimulation.dto;

import lombok.Data;

@Data
public class AccountResponseDTO {
    private boolean success;
    private String message;
    private Integer code;
    private OtpDTO data;
}
