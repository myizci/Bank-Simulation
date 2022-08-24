package com.cydeo.banksimulation.service.implementation;

import com.cydeo.banksimulation.dto.OtpDTO;
import com.cydeo.banksimulation.entity.Account;
import com.cydeo.banksimulation.service.OtpService;
import org.springframework.stereotype.Service;

@Service
public class OtpServiceImpl implements OtpService {
    @Override
    public OtpDTO createOtpSendSms(Account account) {
        return null;
    }

    @Override
    public void confirmOtp(Integer otpCode, Long otpId) {

    }
}
