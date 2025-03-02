package com.danhoh.user.controller;

import com.danhoh.user.entity.User;
import com.danhoh.user.manager.UserCreateManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserCreateManager userCreateManager;

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody User user) {
        log.info("Request to create user...");
        log.debug("Creating user: {}", user);
        userCreateManager.process(user)
                .subscribe();
        log.info("User created");
        log.debug("User created: {}", user);
        return ResponseEntity.ok().build();
    }
}
