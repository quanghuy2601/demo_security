package com.dusty.demo_security.Controllers;

import com.dusty.demo_security.AOP.AuthorizeRequest;
import com.dusty.demo_security.Models.DTO.User.UserCreateDTO;
import com.dusty.demo_security.Models.DTO.User.UserDetailsDTO;
import com.dusty.demo_security.Models.ResModel;
import com.dusty.demo_security.Services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class UserController {

    private final IUserService userService;

    @PostMapping("/register")
    public ResModel<UserDetailsDTO> register(
            @RequestBody UserCreateDTO userCreateDTO
            ) {
        return ResModel.ok(userService.registerUser(userCreateDTO));
    }

    @GetMapping("/{id}/info")
    @AuthorizeRequest(roles = {"ADMIN", "USER"})
    public ResModel<UserDetailsDTO> getUserDetailsById(
            @PathVariable UUID id
    ) {
        // fix: id phải trùng với id trong token
        // xử lý session
        return ResModel.ok(userService.getUserInfo(id));
    }

    @PostMapping("/{id}/update")
    @AuthorizeRequest(roles = {"ADMIN", "USER"})
    public String updateUserDetails(
            @PathVariable UUID id
    ) {
        return "Update User Details Successfully";
    }

}
