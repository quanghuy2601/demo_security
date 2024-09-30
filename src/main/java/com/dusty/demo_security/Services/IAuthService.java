package com.dusty.demo_security.Services;

import com.dusty.demo_security.Models.DTO.Auth.LoginDTO;
import com.dusty.demo_security.Models.DTO.Auth.LoginRequestDTO;

public interface IAuthService {
    LoginDTO login(LoginRequestDTO loginRequest);

    void logout(String refreshToken);

    LoginDTO refresh(String oldRefreshToken);

    boolean comparePassword(String rawPassword, String encodedPassword);
}
