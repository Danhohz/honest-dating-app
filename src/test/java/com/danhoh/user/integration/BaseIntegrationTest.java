package com.danhoh.user.integration;

import com.danhoh.user.repository.UserRepository;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseIntegrationTest {//123adfasdfas

    @LocalServerPort
    private Integer port;

    @Autowired
    private UserRepository userRepository;

    @Container
    static PostgreSQLContainer<?> container = new PostgreSQLContainer<>("postgres:13-alpine");

    protected static RequestSpecification requestSpecification;

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
        requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .setBaseUri("http://localhost:" + port)
                .build();
        userRepository.deleteAll().block();
    }

}
