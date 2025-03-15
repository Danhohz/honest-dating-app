package com.danhoh.user.integration;

import com.danhoh.user.entity.User;
import com.danhoh.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;

public class UserListTest extends BaseIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    private User firsUser;
    private User secondUser;

    @BeforeEach
    void init() {
        firsUser = User.builder()
                .id(UUID.randomUUID())
                .name("Daniil")
                .login("danhoh")
                .email("danhoh@mail.com")
                .age((byte) 23)
                .phone("123456789")
                .password("123456789")
                .description("DESCRIPTION")
                .build();
        secondUser = User.builder()
                .id(UUID.randomUUID())
                .name("Kirill")
                .login("Kir")
                .email("kir@mail.com")
                .age((byte) 25)
                .phone("123456789")
                .password("123456789")
                .description("DESCRIPTION")
                .build();
        userRepository.saveAll(
                List.of(firsUser, secondUser)
        ).blockLast();
    }

    @Test
    void successCase() { //111
        given()
                .spec(requestSpecification)
                .body(User.builder().build())
                .when()
                .get("/api/user/list/v1")
                .then()
                .statusCode(200)
                .body("", hasSize(2));//afasdffadfasdfasf
    }
}
