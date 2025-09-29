package com.example.userservice.dto;

public class UserV3 {
    private String firstName;
    private String lastName;
    private String email;

    public UserV3(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
}