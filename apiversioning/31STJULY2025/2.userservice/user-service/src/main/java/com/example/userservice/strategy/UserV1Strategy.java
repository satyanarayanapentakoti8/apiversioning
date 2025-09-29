package com.example.userservice.strategy;

import com.example.userservice.dto.UserV1;
import org.springframework.stereotype.Component;

@Component
public class UserV1Strategy implements UserVersionStrategy {
    public boolean supports(String version) {
        return "1.0".equals(version);
    }

    public Object getUser() {
        return new UserV1("John Doe");
    }
}