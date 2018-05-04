package com.mailservice.mailservice.service;

import com.mailservice.mailservice.entity.UserDto;

public interface EmailService {

    void sendSimpleMessage(UserDto input);
}
