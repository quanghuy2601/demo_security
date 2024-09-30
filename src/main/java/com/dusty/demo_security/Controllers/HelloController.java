package com.dusty.demo_security.Controllers;

import com.dusty.demo_security.Models.DTO.User.UserDetailsDTO;
import com.dusty.demo_security.Models.ResModel;
import com.dusty.demo_security.Services.Impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hello")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class HelloController {

    private final UserService userService;

    @GetMapping
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/getAllUsers")
    public ResModel<List<UserDetailsDTO>> getAllUsers() {
        return ResModel.ok(userService.getAllUsers());
    }

    // a small update

}
