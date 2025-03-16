package com.danhoh.user.manager;

import com.danhoh.user.entity.User;
import com.danhoh.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserCreateManagerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserCreateManager userCreateManager;

    @Test
    void process_success() {
        User user = User.builder().build();
        doReturn(Mono.just(user)).when(userService).save(any(User.class));
        User rs = userCreateManager.process(user).block();
        verify(userService).save(any());
        assertThat(rs).isNotNull().isEqualTo(user);
    }
}