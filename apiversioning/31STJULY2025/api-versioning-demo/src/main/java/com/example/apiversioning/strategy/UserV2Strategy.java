package com.example.apiversioning.strategy;

import com.example.apiversioning.dto.UserV2;
import org.springframework.stereotype.Component;

@Component
public class UserV2Strategy implements UserVersionStrategy {
    @Override
    public boolean supports(String version) {
        return "2.0".equals(version);
    }

    @Override
    public Object getUserResponse() {
        return new UserV2("John", "Doe", "john.doe@example.com");
    }
}