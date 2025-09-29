package com.example.userservice.strategy;

import com.example.userservice.dto.UserV3;
import org.springframework.stereotype.Component;

@Component
public class UserV3Strategy implements UserVersionStrategy {
    public boolean supports(String version) {
        return "3.0".equals(version);
    }

    public Object getUser() {
        return new UserV3("John", "Doe", "john@example.com");
    }
}