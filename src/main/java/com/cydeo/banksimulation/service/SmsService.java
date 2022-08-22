package com.cydeo.banksimulation.service;

import com.cydeo.banksimulation.dto.SmsRequestDTO;
import org.springframework.stereotype.Service;

@Service // is it necessary here?
public interface SmsService {
    String sendSms(SmsRequestDTO smsRequestDTO);
}
