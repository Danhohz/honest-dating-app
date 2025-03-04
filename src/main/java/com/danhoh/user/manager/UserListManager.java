package com.danhoh.user.manager;

import com.danhoh.user.entity.User;
import com.danhoh.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class UserListManager implements Manager<User, Flux<User>> {

    private final UserService userService;

    @Override
    public Flux<User> process(User input) {
        return userService.getBy(input);
    }
}
