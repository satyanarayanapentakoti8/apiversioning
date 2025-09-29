package com.example.userservice.controller;

import com.example.userservice.service.VersionDispatcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserHeaderVersionController {

    @Autowired
    private VersionDispatcherService dispatcher;

    @GetMapping
    public ResponseEntity<?> getUser(@RequestHeader("X-API-VERSION") String version) {
        return ResponseEntity.ok(dispatcher.getUser(version));
    }
}