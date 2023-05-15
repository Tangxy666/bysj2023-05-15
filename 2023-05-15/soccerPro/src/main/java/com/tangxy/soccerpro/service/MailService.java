package com.tangxy.soccerpro.service;

import com.tangxy.soccerpro.entity.EmailDto;

public interface MailService {
    public void sendMail(EmailDto emailDto);
}
