package com.danhoh.user.integration;

import com.danhoh.user.repository.UserRepository;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseIntegrationTest {

    @LocalServerPort
    private Integer port;

    @Autowired
    private UserRepository userRepository;

    static PostgreSQLContainer<?> container = new PostgreSQLContainer<>("postgres:13-alpine");

    @BeforeAll
    static void beforeAll() {
        container.start();
    }

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.r2dbc.url", () -> "r2dbc://" + container.getHost() + ":" + container.getFirstMappedPort() + "/" + container.getDatabaseName());
        registry.add("spring.r2dbc.username", container::getUsername);
        registry.add("spring.r2dbc.password", container::getPassword);

        registry.add("spring.r2dbc.template.host", container::getHost);
        registry.add("spring.r2dbc.template.port", container::getFirstMappedPort);
        registry.add("spring.r2dbc.template.database", container::getDatabaseName);

        registry.add("spring.datasource.url", container::getJdbcUrl);
        registry.add("spring.datasource.username", container::getUsername);
        registry.add("spring.datasource.password", container::getPassword);
    }

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "http://localhost:" + port;
        userRepository.deleteAll().block();
    }

    @AfterAll
    static void afterAll() {
        container.stop();
    }
}
