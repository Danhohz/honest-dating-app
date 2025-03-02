package com.danhoh.user.manager;

import com.danhoh.user.entity.User;
import com.danhoh.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserCreateManager implements Manager<User, Mono<User>> {

    private final UserRepository userRepository;

    @Override
    public Mono<User> process(User user) {
        user.setId(UUID.randomUUID());
        return userRepository.save(user);
    }
}
