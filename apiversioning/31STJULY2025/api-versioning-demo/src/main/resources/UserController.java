package com.example.apiversioning.controller;

import com.example.apiversioning.service.VersionDispatcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private VersionDispatcherService dispatcher;

    @GetMapping
    public ResponseEntity<?> getUser(@RequestHeader("X-API-VERSION") String version) {
        return ResponseEntity.ok(dispatcher.getResponseForVersion(version));
    }
}