package com.danhoh.user.service;

import com.danhoh.user.entity.User;
import com.danhoh.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Mono<User> save(User user) {
        return userRepository.save(user);
    }
}
