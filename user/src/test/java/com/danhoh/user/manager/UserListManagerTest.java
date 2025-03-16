package com.danhoh.user.manager;

import com.danhoh.user.entity.User;
import com.danhoh.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;

import static com.danhoh.user.util.TestUtils.TestValues.UserValues.AGE;
import static com.danhoh.user.util.TestUtils.TestValues.UserValues.DESCRIPTION;
import static com.danhoh.user.util.TestUtils.TestValues.UserValues.EMAIL;
import static com.danhoh.user.util.TestUtils.TestValues.UserValues.ID;
import static com.danhoh.user.util.TestUtils.TestValues.UserValues.LOGIN;
import static com.danhoh.user.util.TestUtils.TestValues.UserValues.NAME;
import static com.danhoh.user.util.TestUtils.TestValues.UserValues.PASSWORD;
import static com.danhoh.user.util.TestUtils.TestValues.UserValues.PHONE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class UserListManagerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserListManager userListManager;

    @Test
    void process_success() {

        User user = User.builder()
                .id(ID)
                .name(NAME)
                .login(LOGIN)
                .email(EMAIL)
                .age(AGE)
                .phone(PHONE)
                .password(PASSWORD)
                .description(DESCRIPTION)
                .build();

        Flux<User> just = Flux.just(User.builder().build());
        doReturn(just)
                .when(userService).getBy(any(User.class));
        Flux<User> rs = userListManager.process(user);

        assertThat(just).isEqualTo(rs);
    }


}
