package com.dusty.demo_security.Models.DTO.Auth;

import lombok.Data;

@Data
public class LoginRequestDTO {
    private String username;
    private String password;
}
