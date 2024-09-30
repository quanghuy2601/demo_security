package com.dusty.demo_security.Services.Impl;

import com.dusty.demo_security.Exception.BadRequestException;
import com.dusty.demo_security.Models.Constants.Role;
import com.dusty.demo_security.Models.DTO.User.UserCreateDTO;
import com.dusty.demo_security.Models.DTO.User.UserDetailsDTO;
import com.dusty.demo_security.Models.Entities.User;
import com.dusty.demo_security.Repositories.UserRepository;
import com.dusty.demo_security.Services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetailsDTO registerUser(UserCreateDTO userCreate) {
        if(userRepository.existsByUsername(userCreate.getUsername())) {
            throw new BadRequestException("Username existed", 40010);
        }

        User user = User.builder()
                .username(userCreate.getUsername())
                .password(passwordEncoder.encode(userCreate.getPassword()))
                .fullName(userCreate.getFullName())
                .role(Role.valueOf(userCreate.getRole()))
                .build();

        userRepository.save(user);

        return getUserDetails(user);
    }

    public UserDetailsDTO getUserDetails(User user) {
        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();

        userDetailsDTO.setId(user.getId().toString());
        userDetailsDTO.setUsername(user.getUsername());
        userDetailsDTO.setFullName(user.getFullName());
        userDetailsDTO.setRole(user.getRole().toString());

        return userDetailsDTO;
    }

    @Override
    public UserDetailsDTO getUserInfo(UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BadRequestException("User not found", 40004));

        return getUserDetails(user);
    }

    @Override
    public List<UserDetailsDTO> getAllUsers() {
        List<User> listUsers = userRepository.findAll();
        List<UserDetailsDTO> response = new ArrayList<>();
        for(User user : listUsers) {
            response.add(getUserDetails(user));
        }
        return response;
    }
}
