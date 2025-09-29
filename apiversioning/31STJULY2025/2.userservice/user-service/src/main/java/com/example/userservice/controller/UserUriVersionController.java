package com.example.userservice.controller;

import com.example.userservice.dto.UserV1;
import com.example.userservice.dto.UserV2;
import com.example.userservice.dto.UserV3;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserUriVersionController {

    @GetMapping("/v1/users")
    public UserV1 getV1User() {
        return new UserV1("John Doe");
    }

    @GetMapping("/v2/users")
    public UserV2 getV2User() {
        return new UserV2("John", "Doe");
    }

    @GetMapping("/v3/users")
    public UserV3 getV3User() {
        return new UserV3("John", "Doe", "john@example.com");
    }
}