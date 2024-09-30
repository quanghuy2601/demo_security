package com.dusty.demo_security.Models.DTO.Auth;

import com.dusty.demo_security.Models.DTO.User.UserDetailsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {
    private UserDetailsDTO userInfo;
    private TokenDTO token;
}
