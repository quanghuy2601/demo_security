package com.dusty.demo_security.Services;

import com.dusty.demo_security.Models.DTO.User.UserCreateDTO;
import com.dusty.demo_security.Models.DTO.User.UserDetailsDTO;

import java.util.List;
import java.util.UUID;

public interface IUserService {

    UserDetailsDTO registerUser(UserCreateDTO userCreate);

    UserDetailsDTO getUserInfo(UUID userId);

    List<UserDetailsDTO> getAllUsers();
}
