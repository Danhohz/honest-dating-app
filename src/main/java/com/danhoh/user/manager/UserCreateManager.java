package com.danhoh.user.manager;

import com.danhoh.user.entity.User;
import com.danhoh.user.service.UserService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserCreateManager implements Manager<User, Mono<User>> {

    private final UserService userService;

    @Override
    public Mono<User> process(@NotNull User user) {
        user.setId(UUID.randomUUID());
        return userService.save(user);
    }
}
