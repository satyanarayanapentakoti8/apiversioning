package com.example.apiversioning.dto;

public class UserV1 {
    private String fullName;

    public UserV1(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
}