package com.dusty.demo_security.Models.DTO.User;

import lombok.Data;

@Data
public class UserDetailsDTO {
    private String id;
    private String username;
    private String fullName;
    private String role;
}
