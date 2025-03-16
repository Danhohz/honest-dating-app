package com.danhoh.user.service;

import com.danhoh.user.entity.User;
import com.danhoh.user.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void save_success() {
        User user = User.builder().build();
        doReturn(Mono.just(user)).when(userRepository).save(user);
        Mono<User> userMono = userService.save(user);
        Mockito.verify(userRepository).save(user);
        User returnedUser = userMono.block();
        Assertions.assertThat(returnedUser).isNotNull().isEqualTo(user);
        throw new RuntimeException("Opss");
    }
}