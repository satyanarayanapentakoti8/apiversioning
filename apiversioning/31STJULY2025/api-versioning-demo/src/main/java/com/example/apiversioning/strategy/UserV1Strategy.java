package com.example.apiversioning.strategy;

import com.example.apiversioning.dto.UserV1;
import org.springframework.stereotype.Component;

@Component
public class UserV1Strategy implements UserVersionStrategy {
    @Override
    public boolean supports(String version) {
        return "1.0".equals(version);
    }

    @Override
    public Object getUserResponse() {
        return new UserV1("John Doe");
    }
}