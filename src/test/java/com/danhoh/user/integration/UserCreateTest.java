package com.danhoh.user.integration;

import com.danhoh.user.entity.User;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class UserCreateTest extends BaseIntegrationTest {

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
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post("/api/user/create/v1")
                .then()
                .statusCode(200);

    }
}
