package com.dusty.demo_security.Models.DTO.Auth;

import lombok.Data;

@Data
public class TokenDTO {
    private String accessToken;
    private String refreshToken;
}
