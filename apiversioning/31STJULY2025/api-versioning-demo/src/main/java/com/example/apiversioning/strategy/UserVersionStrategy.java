package com.example.apiversioning.strategy;

public interface UserVersionStrategy {
    boolean supports(String version);
    Object getUserResponse();
}