package com.dusty.demo_security.Models.DTO.User;

import lombok.Data;

@Data
public class UserCreateDTO {
    private String username;
    private String password;
    private String fullName;
    private String role;
}
