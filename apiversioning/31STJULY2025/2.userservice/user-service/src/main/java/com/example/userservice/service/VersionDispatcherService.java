package com.example.userservice.service;

import com.example.userservice.strategy.UserVersionStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VersionDispatcherService {

    private final List<UserVersionStrategy> strategies;

    @Autowired
    public VersionDispatcherService(List<UserVersionStrategy> strategies) {
        this.strategies = strategies;
    }

    public Object getUser(String version) {
        return strategies.stream()
                .filter(s -> s.supports(version))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unsupported version"))
                .getUser();
    }
}