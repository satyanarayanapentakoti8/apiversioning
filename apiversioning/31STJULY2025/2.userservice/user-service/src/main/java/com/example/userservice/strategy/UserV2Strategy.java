package com.example.userservice.strategy;

import com.example.userservice.dto.UserV2;
import org.springframework.stereotype.Component;

@Component
public class UserV2Strategy implements UserVersionStrategy {
    public boolean supports(String version) {
        return "2.0".equals(version);
    }

    public Object getUser() {
        return new UserV2("John", "Doe");
    }
}