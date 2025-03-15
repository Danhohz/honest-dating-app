package com.danhoh.user.integration;

import com.danhoh.user.entity.User;
import com.danhoh.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class UserCreateTest extends BaseIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void successCase() {

        User user = User.builder()
                .name("Daniil")
                .login("danhoh")
                .email("danhoh@mail.com")
                .age((byte) 23)
                .phone("123456789")
                .password("123456789")
                .description("DESCRIPTION")
                .build();

        given()
                .spec(requestSpecification)
                .body(user)
                .when()
                .post("/api/user/create/v1")
                .then()
                .statusCode(200);
    }

    @Test
    void validationError() {
        User user = User.builder().build();
        given()
        .spec(requestSpecification)
                .body(user)
                .when()
                .post("/api/user/create/v1")
                .then()
                .statusCode(400);
    }

    @Test
    void successClear() {
        // todo dummy comment another dummy 123
        assertThat(userRepository.count().block()).isEqualTo(0);
    }
}
