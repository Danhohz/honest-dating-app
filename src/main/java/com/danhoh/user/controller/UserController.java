package com.danhoh.user.controller;

import com.danhoh.user.entity.User;
import com.danhoh.user.manager.UserCreateManager;
import jakarta.validation.Valid;
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

    @PostMapping("/api/user/create/v1")
    public ResponseEntity<Void> createUser(@Valid @RequestBody User user) {
        log.info("Request to create user with name {}", user.getName());
        log.debug("Creating user: {}", user);
        userCreateManager.process(user)
                .subscribe(
                        rs -> log.debug("Successfully created user: {}", user),
                        err -> log.error("Error creating user {}", err.toString())
                );
        return ResponseEntity.ok().build();
    }
}
