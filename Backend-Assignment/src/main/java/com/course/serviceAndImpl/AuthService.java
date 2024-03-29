package com.course.serviceAndImpl;

import com.course.entity.LoginDto;

public interface AuthService {
    String login(LoginDto loginDto);
}