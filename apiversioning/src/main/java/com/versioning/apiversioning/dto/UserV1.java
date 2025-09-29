package com.versioning.apiversioning.dto;

public class UserV1 {
    private String name;

    public UserV1(String name) {
        this.name = name;
    }

    public UserV1() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
